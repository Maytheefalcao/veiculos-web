document.addEventListener("DOMContentLoaded", function () {
  const btnCadastrar = document.querySelector(".square-cadastro button");
  const inputs = document.querySelectorAll(".square-cadastro input, .square-cadastro select");
  const tabela = document.getElementById("table-car");

  btnCadastrar.addEventListener("click", function (e) {
    e.preventDefault();

    const marca = inputs[0].value.trim();
    const modelo = inputs[1].value.trim();
    const ano = inputs[2].value.trim();
    const preco = inputs[3].value.trim();
    const status = inputs[4].value.trim();

    if (!marca || !modelo || !ano || !preco || !status) {
      alert("Preencha todos os campos!");
      return;
    }

    const novaLinha = tabela.insertRow(-1);
    const id = tabela.rows.length - 1;

    novaLinha.innerHTML = `
      <td>${id}</td>
      <td>${marca}</td>
      <td>${modelo}</td>
      <td>${ano}</td>
      <td>R$ ${preco}</td>
      <td>${status}</td>
    `;

    alert("✅ Veículo cadastrado com sucesso!");

    inputs.forEach(input => input.value = "");
  });
});
