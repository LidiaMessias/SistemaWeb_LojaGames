package com.sistemaweb.lojagames.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaweb.lojagames.model.Jogos;
import com.sistemaweb.lojagames.repository.JogosRepository;

@Service
public class JogosService {

    @Autowired
    private JogosRepository jogosRepository;

    /**
     * Salva um novo jogo ou atualiza um jogo existente.
     * @param jogos O objeto Jogos a ser salvo/atualizado.
     * @return O objeto Jogos salvo/atualizado.
     */
    public Jogos saveGame(Jogos jogos) { 
        return jogosRepository.save(jogos);
    }

    /**
     * Busca todos os jogos no banco de dados.
     * @return Uma lista de todos os jogos. Pode ser vazia.
     */
    public List<Jogos> getAllGames() {
        return jogosRepository.findAll();
    }

    /**
     * Busca um jogo pelo seu ID para fins de exibição/edição.
     * Retorna Optional.empty() se o jogo não for encontrado.
     * @param id O ID do jogo.
     * @return Um Optional contendo o jogo, se encontrado, ou vazio se não.
     */
    public Optional<Jogos> getGameById(Long id) {
        return jogosRepository.findById(id);
    }

    /**
     * Atualiza um jogo existente.
     * @param id O ID do jogo a ser atualizado.
     * @param jogosDetails O objeto Jogos com os dados atualizados.
     * @return Um Optional contendo o jogo atualizado, se o ID original foi encontrado, ou vazio se não.
     */
    public Optional<Jogos> updateGame(Long id, Jogos jogosDetails) {
        Optional<Jogos> existingGameOptional = jogosRepository.findById(id);

        if (existingGameOptional.isPresent()) {
            Jogos existingGame = existingGameOptional.get();
            // Atualiza apenas os campos que podem ser alterados pelo usuário
            existingGame.setNome(jogosDetails.getNome());
            existingGame.setEstado(jogosDetails.getEstado());
            existingGame.setPreco(jogosDetails.getPreco());
            existingGame.setConsole(jogosDetails.getConsole());

            return Optional.of(jogosRepository.save(existingGame));
        } else {
            return Optional.empty(); // Jogo não encontrado para atualização
        }
    }

    /**
     * Deleta um jogo pelo seu ID.
     * @param id O ID do jogo a ser deletado.
     * @return true se o jogo foi deletado, false se o jogo não foi encontrado.
     */
    public boolean deleteGame(Long id) {
        if (jogosRepository.existsById(id)) {
            jogosRepository.deleteById(id);
            return true;
        }
        return false; // Jogo não encontrado para deletar
    }
}
