package com.example.desafio;

import com.example.desafio.produto.chocolate.Chocolate;
import com.example.desafio.produto.chocolate.ChocolateService;
import com.example.desafio.produto.presente.Presente;
import com.example.desafio.produto.presente.PresenteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PresenteTest {

    @Autowired private PresenteService presenteService;

    @Test
    void criacaoPresente() {
        var presente = new Presente();

        presente.setNome("Presente teste 1");
        presente.setPreco(2.99);

        presenteService.createPresente(presente);

        assertNotNull(presente.getId());
    }

    @Test
    void alteracaoPresente() {
        var presente = new Presente();

        presente.setNome("Teste 2");
        presente.setPreco(3.49);

        presenteService.createPresente(presente);
        var idOriginal = presente.getId();

        presente.setPreco(3.99);

        presenteService.createPresente(presente);

        assertEquals(idOriginal, presente.getId());
        assertEquals(3.99, presente.getPreco());

        var list = presenteService.searchPresente();
    }

    @Test
    void notasPresente() {
        //Gera uma lista contendo 20 chocolates
        var presentes = IntStream.range(0, 20).mapToObj(i -> {
            var presente = new Presente();
            presente.setNome("Presente " + i);
            presente.setPreco((i + 1) / 10D);

            //Os últimos chocolates da lista terão as notas mais altas
            presente.getNota().add((i + 1) / 20D * 10);

            return presente;
        }).collect(Collectors.toList());
        presenteService.saveAll(presentes);
    }
}
