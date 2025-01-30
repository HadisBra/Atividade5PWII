package org.example.atividade4.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.example.atividade4.entity.PessoaJuridica;
import org.example.atividade4.repository.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Transactional

@Controller
@RequestMapping("/pessoajuridica")
public class PessoaJuridicaController {

    @Autowired
    private PessoaJuridicaRepository repository;

    // form de cadastro
    @GetMapping("/form")
    public String form(@RequestParam(required = false) Long id, Model model) {
        if (id != null) {
            PessoaJuridica pessoajuridica = repository.edit(id);
            model.addAttribute("pessoajuridica", pessoajuridica);
        } else {
            model.addAttribute("pessoajuridica", new PessoaJuridica());
        }
        return "pessoajuridica/form";
    }


    @GetMapping("/buscarRazaoSocial")
    public String buscarRazaoSocial(@RequestParam("razaoSocial") String razaoSocial, Model model) {
        List<PessoaJuridica> pessoasjuridica = repository.buscarRazaoSocial(razaoSocial);
        model.addAttribute("pessoasjuridica", pessoasjuridica);
        return "pessoajuridica/list";
    }

    // salvar com validação
    @PostMapping("/save")
    public ModelAndView save(@Valid @ModelAttribute("pessoajuridica") PessoaJuridica pessoajuridica, BindingResult result, RedirectAttributes attributes) {
        try {
            if (result.hasErrors()) {
                return new ModelAndView("pessoajuridica/form");
            }
            repository.save(pessoajuridica);
            attributes.addFlashAttribute("successMessage", "Cadastrado com sucesso!");
            return new ModelAndView("redirect:/pessoajuridica/list");
        } catch (Exception e) {
            result.rejectValue("cnpj", "error.pessoajuridica", "CNPJ já cadastrado");
            return new ModelAndView("pessoajuridica/form");
        }

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