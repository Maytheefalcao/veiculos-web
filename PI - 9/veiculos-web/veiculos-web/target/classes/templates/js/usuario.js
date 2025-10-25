document.addEventListener("DOMContentLoaded", function () {
  const btnCadastrar = document.querySelector(".square-cadastro button");
  const inputs = document.querySelectorAll(".square-cadastro input, .square-cadastro select");
  const tabela = document.getElementById("square-table");

  btnCadastrar.addEventListener("click", function (e) {
    e.preventDefault();

    // Captura os valores
    const nome = inputs[0].value.trim();
    const senha = inputs[1].value.trim();
    const email = inputs[2].value.trim();
    const tipo = inputs[3].value;

    // Validação simples
    if (!nome || !senha || !email || !tipo) {
      alert("⚠️ Todos os campos devem ser preenchidos!");
      return;
    }

    // Verifica formato de email (básico)
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email)) {
      alert("❌ Insira um email válido!");
      return;
    }

    // Adiciona o usuário na tabela
    const novaLinha = tabela.insertRow(-1);
    const id = tabela.rows.length - 1; // gera ID automático

    novaLinha.innerHTML = `
      <td>${id}</td>
      <td>${nome}</td>
      <td>${email}</td>
      <td>${senha.replace(/./g, "*")}</td>
      <td>${tipo}</td>
    `;

    alert("✅ Usuário cadastrado com sucesso!");

    // Limpa os campos
    inputs.forEach((input) => {
      if (input.tagName === "INPUT") input.value = "";
    });
    inputs[3].selectedIndex = 0;
  });
});