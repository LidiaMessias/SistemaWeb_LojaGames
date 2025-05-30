package com.sistemaweb.lojagames.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sistemaweb.lojagames.model.Jogos;
import com.sistemaweb.lojagames.service.JogosService;

import jakarta.validation.Valid;

@Controller
public class LojaGamesController {

    @Autowired
    private JogosService jogosService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/jogos") // Mapeia para GET /jogos
    public String listJogos(Model model) {
        List<Jogos> jogos = jogosService.getAllGames();
        model.addAttribute("jogos", jogos);
        return "listaJogos"; // Retorna "list.html" diretamente na pasta templates
    }

    // Rota para exibir o formulário de CADASTRO de novo jogo
    @GetMapping("/jogos/novo") // Mapeia para GET /jogos/novo
    public String showAddForm(Model model) {
        model.addAttribute("jogos", new Jogos());
        model.addAttribute("titulo", "Cadastrar Novo Jogo");
        return "cadastroJogos"; 
    }

    // Rota para exibir o formulário de EDIÇÃO de jogo existente
    @GetMapping("/jogos/editar/{id}") // Mapeia para GET /jogos/editar/{id}
    public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Jogos> jogosOptional = jogosService.getGameById(id);

        if (jogosOptional.isPresent()) {
            model.addAttribute("jogos", jogosOptional.get());
            model.addAttribute("titulo", "Editar Jogo");
            return "editarJogo"; // Retorna "editarJogo.html" diretamente na pasta templates
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Jogo não encontrado para edição.");
            return "redirect:/jogos"; // Redireciona de volta para a lista se o jogo não for encontrado
        }
    }

    // Rota para SALVAR (cadastrar ou atualizar) um jogo
    @PostMapping("/jogos/salvar") // Mapeia para POST /jogos/salvar (recebe dados dos formulários)
    public String saveOrUpdateGame(@Valid Jogos jogos, BindingResult result, Model model, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            model.addAttribute("jogos", jogos);
            if (jogos.getId() == null) { // Se não tem ID, veio do formulário de cadastro
                model.addAttribute("titulo", "Cadastrar Novo Jogo");
                return "cadastroJogos"; // Retorna "CadastroJogos.html"
            } else { // Se tem ID, veio do formulário de edição
                model.addAttribute("titulo", "Editar Jogo");
                return "editarJogo"; // Retorna "editarJogo.html"
            }
        }

        jogosService.saveGame(jogos);
        //redirectAttributes.addFlashAttribute("successMessage", "Jogo salvo com sucesso!");
        return "redirect:/jogos";
    }

    // Rota para DELETAR um jogo
    @GetMapping("/jogos/deletar/{id}") // Mapeia para GET /jogos/deletar/{id}
    public String deleteGame(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        boolean deleted = jogosService.deleteGame(id);
        if (deleted) {
            redirectAttributes.addFlashAttribute("successMessage", "Jogo excluído com sucesso!");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Erro ao excluir jogo ou jogo não encontrado.");
        }
        return "redirect:/jogos";
    }
}
