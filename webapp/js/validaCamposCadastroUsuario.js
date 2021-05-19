const buttonSave = document.querySelector("#button-salvar-cad");

buttonSave.addEventListener("click", () => {
    const idField = document.querySelector("#id-field").typeof;
    const nameField = document.querySelector("#name-field");
    const surenameField = document.querySelector("#surename-field");
    const birthField = document.querySelector("#birth-field");
    const cpfField = document.querySelector("#cpf-field").value;
    const emailField = document.querySelector("#email-field");
    const telField = document.querySelector("#tel-field").value;
    const userField = document.querySelector("#user-field");
    const passField = document.querySelector("#pass-field");
    const confPassField = document.querySelector("#confpass-field").value;
   
    if (
            idField === String &&
            nameField === null && 
            surenameField === null &&
            birthField === null &&
            cpfField.length !== 11 &&
            emailField === null &&
            telField !== 11 &&
            userField === null && 
            passField === null &&
            confPassField !== passField
        ) {
        alert("Nenhum campo pode estar vazio");
    }
});
