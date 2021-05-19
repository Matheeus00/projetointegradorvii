let botaoIncluir = document.querySelector("#button-salvar-cad");
let botaoRelatorio = document.querySelector("#button-relatorio-cad");
let botaoExcluir = document.querySelector("#button-excluir-cad");
let formIncluir = document.querySelector("#form-requisito");

botaoIncluir.addEventListener("mouseenter", () => {
    formIncluir.removeAttribute("action");
    formIncluir.setAttribute("action", "/ProjetoIntegradorVII/acaoRequisito?param=cadastroRequisito");
});

botaoExcluir.addEventListener("mouseenter", () => {
    formIncluir.removeAttribute("action");
    formIncluir.setAttribute("action", "/ProjetoIntegradorVII/acaoRequisito?param=excluirRequisito");
});

botaoRelatorio.addEventListener("mouseenter", () => {
    formIncluir.removeAttribute("action");
    formIncluir.setAttribute("action", "/ProjetoIntegradorVII/acaoRequisito?param=visualizarTudo");
});