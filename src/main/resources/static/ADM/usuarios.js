const url = "https://projetoplataformaunip-api-1.onrender.com";

async function cadastrarUsuario() {
  const inputNome = document.getElementById("Nome").value;
  const inputEmail = document.getElementById("Email").value;
  const inputSenha = document.getElementById("Senha").value;

  const data = {
    nome: inputNome,
    email: inputEmail,
    senha: inputSenha,
  };

  fetch(url + "/usuario", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
  });
}

async function buscarUsuarios() {
  const lista = document.getElementById("usuarios");
  const cadastro = document.getElementsByClassName("cadastro")[0];

  const res = await fetch(url + "/usuario/all");
  const data = await res.json();

  //Limpa a div
  cadastro.innerHTML = ``;

  //Add o sistema na div
  cadastro.innerHTML = `
    <input placeholder="Nome" id="Nome"/>
    <input placeholder="Email" id="Email" type="email"/>
    <input placeholder="Nome" id="Senha"/>

    <button onClick="cadastrarUsuario()">Cadastrar</button>
  `;

  //Limpa a lista
  lista.innerHTML = `
    <tr>
      <th>Nome</th>
      <th>Email</th>
      <th>Senha</th>
    </tr>
  `;

  //Adiciona as coisas na lista
  lista.innerHTML += data
    .map((user) => {
      return `
      <tr>
        <td>${user.nome}</td>
        <td>${user.email}</td>
        <td>${user.senha}</td>
      </tr>
    `;
    })
    .join();
}
