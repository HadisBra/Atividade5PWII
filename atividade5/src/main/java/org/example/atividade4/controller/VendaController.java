package org.example.atividade4.controller;

import jakarta.transaction.Transactional;
import org.example.atividade4.entity.Venda;
import org.example.atividade4.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@Transactional
@Scope("request")
@Controller
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaRepository vendaRepository;
    @Autowired
    Venda venda; //O spring vai criar o objeto na session
    @Autowired
    private ItemVendaRepository itemVendaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepository;
    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;


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

    @PostMapping("/buscar")
    public ModelAndView buscarData(@RequestParam("databusca") LocalDate data, ModelMap model) {
        if (data != null) {
            model.addAttribute("vendas", vendaRepository.buscarData(data));
        }
        return new ModelAndView("vendas/list");
    }


    @GetMapping("/buscarCliente")
    public String buscarCliente(@RequestParam("id") Long id, ModelMap model) {
        if (id != null) {
            model.addAttribute("vendas", vendaRepository.buscarCliente(id));
        }
        return "vendas/list";
    }

    @GetMapping("/buscarNomeCliente")
    public String buscarNomeCliente(@RequestParam(defaultValue = "") String nome, ModelMap model) {
        List<Venda> vendas = vendaRepository.buscarNomeCliente(nome);
        model.addAttribute("vendas", vendas);
        model.addAttribute("nome", nome);
        return "vendas/list";
    }
}
//
//    // Adicionar produto ao carrinho
//    @GetMapping("produto/add/{id}")
//    public ModelAndView produtoAdd(@PathVariable("id") Long produtoId) {
//        Produto produto = produtoRepository.produto(produtoId);
//        if (produto != null) {
//            ItemVenda itemExistente = null;
//            for (ItemVenda itemVenda : venda.getItemVendas()) {
//                if (itemVenda.getProduto().getId().equals(produtoId)) {
//                    itemExistente = itemVenda;
//                    break;
//                }
//            }
//            if (itemExistente != null) {
//                itemExistente.setQuantidade(itemExistente.getQuantidade() + 1);
//            } else {
//                ItemVenda itemVenda = new ItemVenda();
//                itemVenda.setProduto(produto);
//                itemVenda.setQuantidade(1);
//                itemVenda.setVenda(venda);
//                itemVenda.setData(LocalDate.now()); //Data da venda
//                venda.getItemVendas().add(itemVenda);
//            }
//        }
//        return new ModelAndView("redirect:/produtos/area-compra");
//    }
//
//
//    // Salvar venda
//    @PostMapping("/save")
//    public ModelAndView save(HttpSession session) {
//        if (venda.getItemVendas().isEmpty()) {
//            return new ModelAndView("redirect:/produtos/area-compra");
//        }
//        vendaRepository.save(venda);
//        session.removeAttribute("venda");
//        return new ModelAndView("redirect:/vendas/list");
//    }
//
//
//    // Carrinho de compras
//
//    @GetMapping("/carrinho")
//    public ModelAndView carrinhoList(ModelMap model) {
//        model.addAttribute("pj", pessoaJuridicaRepository.list());
//        model.addAttribute("pf", pessoaFisicaRepository.list());
//        model.addAttribute("pessoas", Stream.concat(pessoaFisicaRepository.list().stream(), pessoaJuridicaRepository.list().stream()).collect(Collectors.toList()));
//        model.addAttribute("itens", vendaRepository.ListVendas());
//        return new ModelAndView();
//    }
//
//
//    // Remover item do carrinho
//    @GetMapping("/session/remove/{index}")
//    public ModelAndView removeItem(@PathVariable("index") int index) {
//        List<ItemVenda> itemVendas = this.venda.getItemVendas();
//        ItemVenda itens = itemVendas.get(index);
//
//        if (itens.getQuantidade() > 1) {
//            itens.setQuantidade(itens.getQuantidade() - 1);
//        } else {
//            this.venda.getItemVendas().remove(index);
//        }
//
//        return new ModelAndView("redirect:/vendas/carrinho");
//
//    }
//
//
//    // Adicionar Pessoa ao carrinho
//    @PostMapping("/addPessoa")
//    public ModelAndView addPessoa(@RequestParam("pessoaId") Long pessoaId) {
//        Pessoa pessoa = pessoaFisicaRepository.pessoaFisica(pessoaId);
//        if (pessoa == null) {
//            pessoa = pessoaJuridicaRepository.pessoaJuridica(pessoaId);
//        }
//        if (pessoa != null) {
//            venda.setPessoa(pessoa);
//        }
//        return new ModelAndView("redirect:/vendas/carrinho");
//    }
//}