// Buscar jogos no db.json
async function carregarProdutos() {
    try {
        const response = await fetch("http://localhost:3000/jogos");
        const jogos = await response.json();

        const jogosContainer = document.getElementById("jogos-container");

        const cards = jogos.map(jogo => {
            const cardContainer = document.createElement("div");
            cardContainer.classList.add("flex", "flex-col", "md:items-center", "mb-20");

            const card = document.createElement("div");
            card.classList.add("flex", "flex-col", "justify-start", "md:w-80", "lg:w-80", "bg-slate-50", "shadow-xl", "shadow-blue-950/90", "rounded-lg", "hover:shadow-2xl", "hover:scale-105", "transition-all");
            cardContainer.appendChild(card);

            const img = document.createElement("img");
            img.src = jogo.imagem;
            img.alt = jogo.nome;
            //img.classList.add("h-72", "md:max-h-72", "w-full");
            img.classList.add("game-img", "rounded-t-lg")
            card.appendChild(img);

            const cardInfos = document.createElement("div");
            cardInfos.classList.add("px-4");
            card.appendChild(cardInfos);

            const nome = document.createElement("h2");
            nome.textContent = jogo.nome;
            nome.classList.add("text-blue-800", "font-bold", "text-lg", "mt-4", "mb-1");
            cardInfos.appendChild(nome);

            const preco = document.createElement("p");
            preco.textContent = `R$ ${jogo.preco.toFixed(2)}`;
            preco.classList.add("pt-3", "text-blue-800", "font-bold", "text-xl", "my-2");
            cardInfos.appendChild(preco);

            const etiquetas = document.createElement("div");
            etiquetas.classList.add("flex");
            cardInfos.appendChild(etiquetas);

            const console = document.createElement("button");
            console.textContent = jogo.console;
            console.classList.add("mr-4", "bg-cyan-50", "border-cyan-500", "border-2", "rounded-3xl", "w-32", "h-10", "px-2", "text-blue-600", "font-normal", "pointer-events-none");
            etiquetas.appendChild(console);

            const estado = document.createElement("button");
            estado.textContent = jogo.estado;
            estado.classList.add("mr-4", "bg-cyan-50", "border-cyan-500", "border-2", "rounded-3xl", "w-32", "h-10", "px-2", "text-blue-600", "font-normal", "pointer-events-none");
            etiquetas.appendChild(estado);

            const edicao = document.createElement("div");
            edicao.classList.add("flex", "justify-between" )
            cardInfos.appendChild(edicao);

            const editarButton = document.createElement("button");
            editarButton.textContent = "Editar";
            editarButton.classList.add("h-11", "w-32", "my-4", "font-medium", "bg-blue-600", "flex-row", "overflow-hidden", "text-slate-50", "text-base", "hover:bg-blue-400", "hover:font-semibold", "transition-all", "hover:scale-105");
            editarButton.onclick = () => {
                window.location.href = "editarJogo.html";
            };
            edicao.appendChild(editarButton);

            const deleteButton = document.createElement("button");
            deleteButton.textContent = "Deletar";
            deleteButton.classList.add("h-11", "w-32", "my-4", "font-medium", "bg-neutral-500", "flex-row", "overflow-hidden", "text-slate-50", "text-base", "hover:bg-neutral-700", "hover:font-semibold", "transition-all", "hover:scale-105");
            /* Colocar a ação do botão deletar aqui  */
            edicao.appendChild(deleteButton);

            return cardContainer; // Retorna o card criado
        });

        jogosContainer.append(...cards);
    } catch (error) {
        console.error("Erro ao carregar os jogos: ", error);
    }

}
// Chamar a função para carregar os jogos ao carregar a página
window.onload = carregarProdutos;