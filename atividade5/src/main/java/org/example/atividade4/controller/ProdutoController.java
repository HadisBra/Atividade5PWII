package org.example.atividade4.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.example.atividade4.entity.Produto;
import org.example.atividade4.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Transactional
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/form")
    public String form(Produto produto) {
        return "produtos/form";
    }


    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("produtos", produtoRepository.ListProduto());
        return new ModelAndView("produtos/list");
    }

    @GetMapping("/buscar_produto")
    public String buscarProduto(@RequestParam("descricao") String descricao, Model model) {
        List<Produto> produtos = produtoRepository.buscarProduto(descricao);
        model.addAttribute("produtos", produtos);
        return "produtos/list";
    }


    @PostMapping("/save")
    public ModelAndView save(@Valid Produto produto, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("produtos/form");
        }
        produtoRepository.save(produto);
        return new ModelAndView("redirect:/produtos/list");
    }


    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        produtoRepository.deleteId(id);
        return new ModelAndView("redirect:/produtos/list");
    }


    @PostMapping("/update")
    public ModelAndView update(Produto produto) {
        produtoRepository.update(produto);
        return new ModelAndView("redirect:/produtos/list");
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Produto produto = produtoRepository.edit(id);
        model.addAttribute("produto", produto);
        return "produtos/form";
    }


    @GetMapping("/area-compra")
    public ModelAndView listProdutos(ModelMap model) {
        model.addAttribute("produtos", produtoRepository.ListProduto());
        return new ModelAndView("produtos/area-compra");
    }

    @GetMapping("/area-compra/buscar")
    public String buscarProdutoAreaCompra(@RequestParam("descricao") String descricao, Model model) {
        List<Produto> produtos = produtoRepository.buscarProduto(descricao);
        model.addAttribute("produtos", produtos);
        return "produtos/area-compra";
    }
}