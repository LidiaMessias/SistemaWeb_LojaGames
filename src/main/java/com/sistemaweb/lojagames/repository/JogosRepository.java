package com.sistemaweb.lojagames.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sistemaweb.lojagames.model.Jogos;

@Repository
public interface JogosRepository extends JpaRepository<Jogos, Long>{
    //CRUD básico
    //Os métodos como save(), findById(), findAll(), deleteById() já são herdados.
}
