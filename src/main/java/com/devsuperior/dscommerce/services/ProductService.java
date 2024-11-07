package com.devsuperior.dscommerce.services;


import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        // Variável result recebendo o produto que tem esse id.
        Optional<Product> result = repository.findById(id);
        // Para pegar o produto dentro do result
        Product product = result.get();
        //Para converter o produto em DTO
        //Vai ser copiado os dados que estão em ProductDTO
        ProductDTO dto = new ProductDTO(product);
        return dto;
    }



}
