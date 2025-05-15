let formName = document.getElementById('first-name'); 
let lastName = document.getElementById('last-name');  
let email = document.getElementById('email');   
let message = document.getElementById('message');  
let formulario = document.getElementById('formulario'); 

const validarEmail = /\w+@\w+\.\w+/;          
const validarCampoVazio = /^[a-zA-Z\s]+$/;  
const validarMessage = /\b\w+\b/g;              

formulario.addEventListener("submit", function(event) {
    event.preventDefault();

    let formMessage = message.value.match(validarMessage);
    
    if(formName.value.trim() === "" || !validarCampoVazio.test(formName.value)) {
        formName.value = "";
        formName.placeholder = "Campo de preenchimento obrigatório.";
        return;

    } else if (lastName.value.trim() === "" || !validarCampoVazio.test(lastName.value)) {
        lastName.value = "";
        lastName.placeholder = "Campo de preenchimento obrigatório.";
        return;
    
    } else if(email.value.trim() === "" || !validarEmail.test(email.value)) {
        email.value = "";
        email.placeholder = "Digite um endereço de e-mail válido.";
        return;

    } else if (!formMessage && formMessage < 10) {
        message.value = "";
        message.placeholder = "Preencha este campo com ao menos 10 palavras.";
        return;

    } else {
        localStorage.setItem('first-name', formName.value);
        localStorage.setItem('last-name', lastName.value);
        localStorage.setItem('email', email.value);
        localStorage.setItem('message', message.value);

        formName.placeholder = "";
        lastName.placeholder = "";
        email.placeholder = "";
        message.placeholder = "";

        formName.value = "";
        lastName.value = "";
        email.value = "";
        message.value = "";
    }; 
    
});

let formEmail = document.querySelector('.form-email');

formEmail.addEventListener("submit", function(event) {
    event.preventDefault();

    let emailField = document.getElementById('email-recentproj');
    const validarEmail = /\w+@\w+\.\w+/; 

    if(emailField.value.trim() === '' || !validarEmail.test(emailField.value)) {
        emailField.value = "";
        emailField.placeholder = "Digite um e-mail válido";
        return;
    } else {
        localStorage.setItem("email", emailField.value); 
        emailField.placeholder = "Enter email address";
        emailField.value = "";
    };
        
});

