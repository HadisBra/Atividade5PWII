package org.example.atividade4.controller;

import jakarta.transaction.Transactional;
import org.example.atividade4.entity.Venda;
import org.example.atividade4.repository.VendaRepository;
import org.example.atividade4.repository.ItemVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@Controller
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ItemVendaRepository itemVendaRepository;

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("vendas", vendaRepository.ListVendas());
        return new ModelAndView("vendas/list");
    }
    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") Long id, ModelMap model) {
        Venda venda = vendaRepository.DetailVenda(id);
        if (venda != null) {
            model.addAttribute("venda", venda);
            model.addAttribute("itensVenda", itemVendaRepository.DetalhesItemVenda(id));
        }
        return new ModelAndView("vendas/detail");
    }

}
