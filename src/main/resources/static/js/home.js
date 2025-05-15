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