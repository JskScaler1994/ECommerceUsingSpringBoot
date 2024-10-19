package com.example.productservice.Services;

import com.example.productservice.Models.*;
import com.example.productservice.Repo.CategoryRepository;
import com.example.productservice.Repo.ProductRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service("ProductDBService")
public class ProductDBService implements ProductService {

    ProductRepository productRepository;
    CategoryRepository categoryRepository;

    public ProductDBService(ProductRepository productRepository,
                            CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public product getProductById(long id) throws productNotFoundException {
        return productRepository.findById(id).get();
    }

    @Override
    public List<product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public product createProduct(String title,
                                 Double price,
                                 String description,
                                 String image,
                                 String category) {
        product p = new product();
        p.setTitle(title);
        p.setPrice(price);
        p.setDescription(description);
        p.setImageUrl(image);
        p.setCategory(getCategoryByName(category));

        return productRepository.save(p);
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public product updateProduct(long id,
                                 String title,
                                 Double price,
                                 String description,
                                 String image,
                                 String category) throws productNotFoundException {
        Optional<product> p = productRepository.findById(id);
        if(p.isEmpty()){
            throw new productNotFoundException("Product not found to be updated");
        }
        product ProductToUpdate = p.get();

        if(title != null){
            ProductToUpdate.setTitle(title);
        }
        if(price != null){
            ProductToUpdate.setPrice(price);
        }
        if(description != null){
            ProductToUpdate.setDescription(description);
        }
        if(image != null){
            ProductToUpdate.setImageUrl(image);
        }
        if(category != null){
            ProductToUpdate.setCategory(getCategoryByName(category));
        }

        return productRepository.save(ProductToUpdate);
    }

    @Override
    public List<product> getTop5() {
        return List.of();
    }

    /* This method is created to fetch the Category from the DB using the category name */
    public category getCategoryByName(String catName) {
        Optional<category> cat = categoryRepository.findByName(catName);
        if(cat.isEmpty()){
            category c = new category();
            c.setName(catName);
            return categoryRepository.save(c);
        }

        return cat.get();
    }
}
