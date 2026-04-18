const api = "http://localhost:8080";

const conteudo = document.getElementById("conteudo");

function criarTabela(headers, rows){

let html = "<table>";

html += "<tr>";
headers.forEach(h => html += `<th>${h}</th>`);
html += "</tr>";

rows.forEach(r => {

html += "<tr>";

r.forEach(c => html += `<td>${c}</td>`);

html += "</tr>";

});

html += "</table>";

return html;

}



////////////////////////
//// USUARIOS
////////////////////////

async function listarUsuarios(){

let res = await fetch(api + "/usuario");
let usuarios = await res.json();

let rows = usuarios.map(u => [

u.id,
u.nome,
u.email,
`<button onclick="deletarUsuario(${u.id})">Excluir</button>`

]);

conteudo.innerHTML = `

<h2>Usuários</h2>

<button onclick="criarUsuario()">Novo Usuário</button>

${criarTabela(["ID","Nome","Email","Ações"], rows)}

`;

}

async function criarUsuario(){

let nome = prompt("Nome do usuário");
let email = prompt("Email");
let senha = prompt("Senha");

await fetch(api + "/usuario",{

method:"POST",

headers:{
"Content-Type":"application/json"
},

body:JSON.stringify({
nome:nome,
email:email,
senha:senha
})

});

listarUsuarios();

}

async function deletarUsuario(id){

await fetch(api + "/usuario?id=" + id,{
method:"DELETE"
});

listarUsuarios();

}



////////////////////////
//// DESAFIOS
////////////////////////

async function listarDesafios(){

let res = await fetch(api + "/desafio/all");
let desafios = await res.json();

let rows = desafios.map(d => [

d.id,
d.pergunta,
d.tema,
d.type,
`<button onclick="deletarDesafio(${d.id})">Excluir</button>`

]);

conteudo.innerHTML = `

<h2>Desafios</h2>

<button onclick="criarDesafio()">Novo Desafio</button>

${criarTabela(["ID","Pergunta","Tema","Tipo","Ações"], rows)}

`;

}

async function criarDesafio(){

let type = prompt("Tipo do desafio (multiplo ou trueorfalse)");
if(!type) return;

let pergunta = prompt("Pergunta do desafio");
if(!pergunta) return;

let tema = prompt("Tema (ex: reciclagem, energia, animais)");
if(!tema) return;

let respostas = [];

if(type === "multiplo"){

respostas.push(prompt("Resposta correta"));
respostas.push(prompt("Resposta incorreta 1"));
respostas.push(prompt("Resposta incorreta 2"));
respostas.push(prompt("Resposta incorreta 3"));

}

else if(type === "trueorfalse"){

respostas.push("Verdadeiro");
respostas.push("Falso");

}

else{

alert("Tipo inválido");
return;

}

await fetch(api + "/desafio",{

method:"POST",

headers:{
"Content-Type":"application/json"
},

body:JSON.stringify({

type:type,
pergunta:pergunta,
resposta:respostas,
tema:tema

})

});

listarDesafios();

}

async function deletarDesafio(id){

await fetch(api + "/desafio?id=" + id,{
method:"DELETE"
});

listarDesafios();

}


////////////////////////
//// ATIVIDADES
////////////////////////

async function listarAtividades(){

let res = await fetch(api + "/atividade/all");
let atividades = await res.json();

let rows = atividades.map(a => [

a.id,
a.type,
a.nome,
a.icon ?? "null",
a.teoria ? a.teoria.join(", ") : "",
`<button onclick="deletarAtividade(${a.id})">Excluir</button>`

]);

conteudo.innerHTML = `

<h2>Atividades</h2>

<button onclick="criarAtividade()">Nova Atividade</button>

${criarTabela(
["ID","Tipo","Nome","Icon","Conteúdo","Ações"],
rows
)}

`;

}



async function criarAtividade(){

let type = prompt("Tipo da atividade (teoria ou desafio)");
if(!type) return;

let nome = prompt("Nome da atividade (ex: Reciclagem)");
if(!nome) return;

let icon = prompt("Nome do icone (pode deixar vazio)");
if(icon === "") icon = null;

let teoria = [];

if(type === "teoria"){

let quantidade = prompt("Quantos textos terá essa teoria?");
quantidade = parseInt(quantidade);

for(let i=0;i<quantidade;i++){

let texto = prompt("Texto " + (i+1));
if(texto) teoria.push(texto);

}

}

else if(type === "desafio"){

let quantidade = prompt("Quantos desafios essa atividade terá?");
quantidade = parseInt(quantidade);

for(let i=0;i<quantidade;i++){

let idDesafio = prompt("ID do desafio " + (i+1));
if(idDesafio) teoria.push(idDesafio);

}

}

else{

alert("Tipo inválido");
return;

}

await fetch(api + "/atividade",{

method:"POST",

headers:{
"Content-Type":"application/json"
},

body:JSON.stringify({

type:type,
nome:nome,
icon:icon,
teoria:teoria

})

});

listarAtividades();

}



async function deletarAtividade(id){

await fetch(api + "/atividade?id=" + id,{
method:"DELETE"
});

listarAtividades();

}