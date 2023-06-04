package com.springproject.eventoapp.controller;

import com.springproject.eventoapp.models.Evento;
import com.springproject.eventoapp.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventoController {

    @Autowired //injecao de dependencia
    private EventoRepository er;

    @RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET)
    public String form(){
        return "evento/formEvento";
    }

    @RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST)
    public String form(Evento evento){

        er.save(evento); //salva os dados do Evento no BD
        return "redirect:/cadastrarEvento";
    }

    @RequestMapping("/eventos")
    public ModelAndView listarEventos(){
        ModelAndView mv = new ModelAndView("/index");
        Iterable<Evento> eventos = er.findAll();
        mv.addObject("eventos",eventos);
        return mv;
    }

    @RequestMapping("/{codigo}")
    public ModelAndView detalhesEvento(@PathVariable("codigo") long codigo){
        Evento evento = er.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("evento/detalhesEvento");
        mv.addObject("evento",evento);
        return mv;
    }
}
