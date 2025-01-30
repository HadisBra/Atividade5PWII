package org.example.atividade4.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.example.atividade4.entity.PessoaFisica;
import org.example.atividade4.repository.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Transactional
@Controller
@RequestMapping("/pessoafisica")
public class PessoaFisicaController {

    @Autowired
    PessoaFisicaRepository pessoaFisicaRepository;

    // form de cadastro
    @GetMapping("/form")
    public String form(@RequestParam(required = false) Long id, Model model) {
        if (id != null) {
            PessoaFisica pessoaFisica = pessoaFisicaRepository.edit(id);
            model.addAttribute("pessoafisica", pessoaFisica);
        } else {
            model.addAttribute("pessoafisica", new PessoaFisica());
        }
        return "pessoafisica/form";
    }

    @GetMapping("/buscar_nome")
    public ModelAndView buscarNome(@RequestParam("nomeBusca") String nome, Model model) {
        model.addAttribute("pessoasfisica", pessoaFisicaRepository.buscarNome(nome));
        return new ModelAndView("/pessoafisica/list");
    }

    // salvar com validação
    @PostMapping("/save")
    public ModelAndView save(@Valid @ModelAttribute("pessoafisica") PessoaFisica pessoaFisica, BindingResult result, RedirectAttributes attributes) {
        try {
            if (result.hasErrors()) {
                return new ModelAndView("pessoafisica/form");
            }
            pessoaFisicaRepository.save(pessoaFisica);
            return new ModelAndView("redirect:/pessoafisica/list");
        } catch (Exception e) {
            result.rejectValue("cpf", "error.pessoafisica", "CPF já cadastrado");
            return new ModelAndView("pessoafisica/form");
        }
    }

    @PostMapping("/update")
    public ModelAndView update(@Valid @ModelAttribute("pessoafisica") PessoaFisica pessoaFisica, BindingResult result, RedirectAttributes attributes) {

        try {
            if (result.hasErrors()) {
                return new ModelAndView("pessoafisica/form");
            }
            pessoaFisicaRepository.update(pessoaFisica);
            return new ModelAndView("redirect:/pessoafisica/list");
        } catch (Exception e) {
            result.rejectValue("cpf", "error.pessoafisica", "CPF já cadastrado");
            return new ModelAndView("pessoafisica/form");
        }
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