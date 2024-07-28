package com.project.shopapp.services;

import com.project.shopapp.dtos.ProductDTO;
import com.project.shopapp.models.Category;
import com.project.shopapp.models.Product;
import com.project.shopapp.models.ProductImage;
import com.project.shopapp.reposistories.CategoryReposistory;
import com.project.shopapp.reposistories.ProductReposistory;
import com.project.shopapp.responses.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.Optional;

@Service
public class ProductService implements  ProductServiceInterface{
    private ProductReposistory productReposistory;
    private CategoryReposistory categoryReposistory;
    private ProductImageRepository productImageRepository;

    public ProductService(ProductReposistory productReposistory,
                          CategoryReposistory categoryReposistory
                          )
    {
        this.productReposistory = productReposistory;
        this.categoryReposistory = categoryReposistory;
    }
    @Override
    public Product createProduct(ProductDTO productDTO) {
        Category existsCategory = categoryReposistory.findById(productDTO.getCategoryId())
                .orElseThrow();

        Product newProduct = new Product(
                productDTO.getName(),
                productDTO.getPrice(),
                productDTO.getThumbnail(),
                existsCategory
                );
        return productReposistory.save(newProduct);
    }

    @Override
    public Product getProductbyID(Long productId) {
        return productReposistory.findById(productId).
                orElseThrow();
    }


    @Override
    public Product updateProduct(Long productId, ProductDTO productDTO) {
        Product existsProduct = getProductbyID(productId);
        if (existsProduct != null)
        {
            Category existsCategory = categoryReposistory.findById(productDTO.getCategoryId())
                    .orElseThrow();
            existsProduct.setCategory(existsCategory);
            existsProduct.setName(productDTO.getName());
            existsProduct.setPrice(productDTO.getPrice());
            existsProduct.setThumbnail(productDTO.getThumbnail());
            return productReposistory.save(existsProduct);
            // Copy các thuộc tính từ DTO sang Object
        }
        return null;
    }

    @Override
    public void deleteProduct(long productId) {
        Optional<Product> productOptional = productReposistory.findById(productId);
        if(productOptional.isPresent())
        {
            productReposistory.delete(productOptional.get());
        }
    }

}
