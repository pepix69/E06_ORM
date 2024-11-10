package com.upiiz.orm.repositories;

import com.upiiz.orm.models.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Jpa y crud repo
@Repository
public interface ClienteReposotiry extends JpaRepository<ClienteEntity, Long> {
    //Generar consultas mas persosnalizadas
}
