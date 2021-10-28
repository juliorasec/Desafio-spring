package com.example.desafio.produto;

import com.example.desafio.produto.dto.CatalogoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProdutoService {

    @Autowired private ProdutoRepository repository;

    public List<CatalogoDTO> getTop10Notas() {
        final List<Produto> listProdutos = new ArrayList<>();
        final List<CatalogoDTO> listCatalogo = new ArrayList<>();
        repository.findAll().forEach(listProdutos::add);
        listProdutos.stream().forEach(i -> {
            CatalogoDTO catalogoDTO = new CatalogoDTO();
            catalogoDTO.setMediaNotas(i.getNota().stream()
                    .mapToDouble(Double::doubleValue)
                    .average().getAsDouble());
            catalogoDTO.setNome(i.getNome());
            listCatalogo.add(catalogoDTO);
        });
        Collections.sort(listCatalogo, (a,b) -> b.getMediaNotas().compareTo(a.getMediaNotas()));
        return listCatalogo.stream()
                .limit(10)
                .collect(Collectors.toList());

    }
}
