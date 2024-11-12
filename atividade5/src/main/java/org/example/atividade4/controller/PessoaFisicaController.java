package org.example.atividade4.controller;

import jakarta.transaction.Transactional;
import org.example.atividade4.entity.Pessoa;
import org.example.atividade4.entity.PessoaFisica;
import org.example.atividade4.repository.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@Controller
@RequestMapping("/pessoafisica")
public class PessoaFisicaController {

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;


    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("pessoafisica", new PessoaFisica());
        return "pessoafisica/form";
    }
        @PostMapping("/save")
        public ModelAndView save(PessoaFisica pessoaFisica) {
            pessoaFisicaRepository.save(pessoaFisica);
           return new ModelAndView("redirect:/pessoafisica/list");
        }

        @PostMapping("/update")
        public ModelAndView update(PessoaFisica pessoaFisica) {
            pessoaFisicaRepository.update(pessoaFisica);
            return new ModelAndView("redirect:/pessoafisica/list");
        }
        @GetMapping("/list")
        public String list(Model model) {
            model.addAttribute("pessoasfisica", pessoaFisicaRepository.list());
            return "pessoafisica/list";
        }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        PessoaFisica pessoaFisica = pessoaFisicaRepository.edit(id);
        model.addAttribute("pessoafisica", pessoaFisica);
        return "pessoafisica/form";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        pessoaFisicaRepository.deleteId(id);
        return new ModelAndView("redirect:/pessoafisica/list");
    }

    }
