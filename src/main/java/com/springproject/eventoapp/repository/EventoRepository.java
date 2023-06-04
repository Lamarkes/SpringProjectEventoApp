package com.springproject.eventoapp.repository;

import com.springproject.eventoapp.models.Evento;
import org.springframework.data.repository.CrudRepository;

public interface EventoRepository extends CrudRepository<Evento,String> {

    Evento findByCodigo(long codigo);


}
