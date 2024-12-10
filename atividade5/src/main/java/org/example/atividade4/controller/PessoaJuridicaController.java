package org.example.atividade4.controller;

import jakarta.transaction.Transactional;
import org.example.atividade4.entity.Pessoa;
import org.example.atividade4.entity.PessoaFisica;
import org.example.atividade4.entity.PessoaJuridica;
import org.example.atividade4.repository.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Transactional
@Controller
@RequestMapping("/pessoajuridica")
public class PessoaJuridicaController {

    @Autowired
    private PessoaJuridicaRepository repository;


    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("pessoajuridica", new PessoaJuridica());
        return "pessoajuridica/form";
    }

    @PostMapping("/save")
    public ModelAndView save(PessoaJuridica pessoajuridica) {
        repository.save(pessoajuridica);
        return new ModelAndView("redirect:/pessoajuridica/list");
    }


    @PostMapping("/update")
    public ModelAndView update(PessoaJuridica pessoaJuridica) {
        repository.updatePJ(pessoaJuridica);
        return new ModelAndView("redirect:/pessoajuridica/list");
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("pessoasjuridica", repository.list());
        return "pessoajuridica/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        PessoaJuridica pessoajuridica = repository.edit(id);
        model.addAttribute("pessoajuridica", pessoajuridica);
        return "pessoajuridica/form";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        repository.deleteId(id);
        return new ModelAndView("redirect:/pessoajuridica/list");
    }

}