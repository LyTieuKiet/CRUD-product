package com.project.shopapp.services;

import com.project.shopapp.dtos.ProductDTO;
import com.project.shopapp.dtos.ProductImageDTO;
import com.project.shopapp.models.Product;
import com.project.shopapp.models.ProductImage;
import com.project.shopapp.responses.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


import java.util.List;


public interface ProductServiceInterface {

    Product createProduct(ProductDTO productDTO);

    Product getProductbyID (Long productId);
    

    Product updateProduct (Long productId, ProductDTO productDTO);

    void deleteProduct (long productId);


}
