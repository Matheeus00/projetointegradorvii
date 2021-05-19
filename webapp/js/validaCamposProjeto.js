const button = document.querySelector("#button-salvar-cad");

button.addEventListener("click", () => {
   const titulo = document.querySelector("#title-field").value.length;
   const descricao = document.querySelector("#desc-field").value.length; 
   
   if (titulo === 0 && descricao === 0) {
       alert("Nenhum campo pode estar vazio");
   }
});