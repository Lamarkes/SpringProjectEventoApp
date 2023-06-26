package com.springproject.eventoapp.repository;

import com.springproject.eventoapp.models.Convidado;
import com.springproject.eventoapp.models.Evento;
import org.springframework.data.repository.CrudRepository;

public interface ConvidadoRepository extends CrudRepository<Convidado,String> {

    Iterable<Convidado> findByEvento(Evento evento);
}
