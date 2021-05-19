const button = document.querySelector("#button-login");
const formLogin = document.querySelector("#form-login");


button.addEventListener("click", () => {
    const userField = document.querySelector("#user-field").value.length;
    const passField = document.querySelector("#pass-field").value.length;
   
    if (userField === 0 && passField === 0) {
        alert("Campos Usuário e Senha estão vazios");
    }
});

button.addEventListener("mouseenter", () => {
    formLogin.removeAttribute("action");
    formLogin.setAttribute("action", "/ProjetoIntegradorVII/acao?param=login");
});