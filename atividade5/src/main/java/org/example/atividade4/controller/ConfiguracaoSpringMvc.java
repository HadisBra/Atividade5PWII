package org.example.atividade4.controller;



import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Configuration para indicar ao Spring que essa é uma classe de configuração.
 * Em seguida, é preciso estender a classe WebMvcConfigurerAdapter.
 * @author fagno
 */
@Configuration
public class ConfiguracaoSpringMvc implements WebMvcConfigurer{

    /**
     * Com a chamada a registry.addViewController(), estamos registrando um controller automático,
     * definido pelo próprio Spring, para atender a requisições direcionadas à URL / e /home. E com a chamada
     * a setViewName(), sempre que a aplicação receber uma requisição para um desses endereços, a view home,
     * criada na última aula, será exibida.
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/home");
        registry.addViewController("/home").setViewName("vendas/list");
        registry.addViewController("/home").setViewName("pessoafisica/form");
        registry.addViewController("/home").setViewName("pessoafisica/list");
        registry.addViewController("/home").setViewName("pessoajuridica/form");
        registry.addViewController("/home").setViewName("pessoajuridica/list");




    }

}
