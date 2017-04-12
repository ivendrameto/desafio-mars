package br.eti.vendrameto.desafio.mars.cfg;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "br.eti.vendrameto.desafio.mars")
public class MarsConfiguration {

}
