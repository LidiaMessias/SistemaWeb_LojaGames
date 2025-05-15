function toggleSubMenu(event) {
    event.preventDefault(); // Impede a navegação padrão do link
    const submenu = document.getElementById('submenu');
    submenu.classList.toggle('hidden');
}
