let botaoSalvar = document.querySelector("#button-salvar-cad");
let botaoConsultar = document.querySelector("#button-consultar-cad");
let botaoExcluir = document.querySelector("#button-excluir-cad");
let form = document.querySelector("#form-cadastro");

botaoSalvar.addEventListener("mouseenter", () => {
    form.removeAttribute("action");
    form.setAttribute("action", "/ProjetoIntegradorVII/acao?param=cadastroPessoa");
});

botaoExcluir.addEventListener("mouseenter", () => {
    form.removeAttribute("action");
    form.setAttribute("action", "/ProjetoIntegradorVII/acao?param=excluirPessoa");
});

botaoConsultar.addEventListener("mouseenter", () => {
    form.removeAttribute("action");
    form.setAttribute("action", "/ProjetoIntegradorVII/acao?param=consultarPessoa");
});