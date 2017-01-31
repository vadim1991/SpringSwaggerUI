package com.test.web;

import com.test.datamodel.Product;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    private Map<String, Product> products = new HashMap<>();

    @ApiOperation(value = "Create new product", response = Product.class)
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public Product createNew(@RequestBody Product product) {
        products.put(product.getId(), product);
        return product;
    }

    @ApiOperation(value = "Get product by ID", response = Product.class)
    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public Product getByID(@PathVariable String id) {
        return products.get(id);
    }

    @ApiOperation(value = "Find all products", response = Product.class, responseContainer = "List")
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> getAll() {
        return new ArrayList<>(products.values());
    }

}
