let botaoIncluir = document.querySelector("#button-salvar-cad");
let botaoExcluir = document.querySelector("#button-excluir-cad");
let botaoConsultar = document.querySelector("#button-consultar-cad");
let botaoRelatorio = document.querySelector("#button-relatorio-cad")
let form = document.querySelector("#form-projeto");

botaoIncluir.addEventListener("mouseenter", () => {
    form.removeAttribute("action");
    form.setAttribute("action", "/ProjetoIntegradorVII/acaoProjeto?param=cadastroProjeto");
});

botaoExcluir.addEventListener("mouseenter", () => {
    form.removeAttribute("action");
    form.setAttribute("action", "/ProjetoIntegradorVII/acaoProjeto?param=excluirProjeto");
});

botaoConsultar.addEventListener("mouseenter", () => {
    form.removeAttribute("action");
    form.setAttribute("action", "/ProjetoIntegradorVII/acaoProjeto?param=consultarProjeto");
});

botaoRelatorio.addEventListener("mouseenter", () => {
    form.removeAttribute("action");
    form.setAttribute("action", "/ProjetoIntegradorVII/acaoProjeto?param=visualizarTudo");
});