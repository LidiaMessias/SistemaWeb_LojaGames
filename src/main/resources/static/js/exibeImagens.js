const imagens = [
    "/uploadimages/PS-5_AssassinsCreedMirage.jpg",
    "/uploadimages/PS-5_Astrobot.jpg",
    "/uploadimages/PS-5_AvatarFrontiersOfPandora.jpg",
    "/uploadimages/PS-5_DragonBallSparkingZero.jpg",
    "/uploadimages/PS-5_DragonsDogma.jpg",
    "/uploadimages/PS-5_GrandTheftAutoV.jpg",
    "/uploadimages/PS-5_EldenRing.jpg",
    "/uploadimages/PS-5_FinalFantasyVII.jpg",
    "/uploadimages/PS-5_GodOfWarRagnarok.jpg",
    "/uploadimages/PS-5_HogwartsLegacy.jpg",
    "/uploadimages/PS-5_HorizonForbiddenWest.jpg",
    "/uploadimages/PS-5_HorizonZeroDawn.jpg",
    "/uploadimages/PS-5_MortalKombat.jpg",
    "/uploadimages/PS-5_SonicShadow.jpg",
    "/uploadimages/PS-5_SonicSuperstars.jpg",
    "/uploadimages/PS-5_SpiderMan2.jpg"
]

const produtoImagem = document.querySelectorAll(".game-img");
produtoImagem.forEach((img, index) => {
    const imagem = imagens[index % imagens.length];
    img.setAttribute("src", imagem);
});
