package com.oop.project.controller.endpoint;

import com.oop.project.controller.gestor.SingletonData;
import com.oop.project.controller.response.EntityResponse;
import com.oop.project.controller.response.ErrorResponse;
import com.oop.project.controller.response.ListResponse;
import com.oop.project.controller.response.Response;
import com.oop.project.model.product.Product;
import com.oop.project.model.user.User;
import com.oop.project.common.exception.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/products")
public class ProductController {
    SingletonData singletonData = SingletonData.getSingletonInstance();
    private Map<Integer, Product> products = singletonData.getProducts();
    private Map<Integer, User> users = singletonData.getUsers();
    private AtomicInteger id = singletonData.getProductsId();

    @GetMapping()
    public ListResponse<Integer, Product> index() {
        List<Product> results = new ArrayList<>(products.values());
        ListResponse<Integer, Product>  response = new ListResponse<Integer, Product>(HttpServletResponse.SC_OK, true, results.size(), results);
        return response;
    }

    @PostMapping("/create")
    public Response create2(Product product, @RequestParam(required=false,name="seller") Integer sellerField, @RequestParam(value = "seller_id") Integer seller_id){
        try {
            product.validate();
            if (users.containsKey(seller_id)) {
                User seller = users.get(seller_id);
                int productId = id.getAndIncrement();
                product.setId(productId);
                product.setSeller(seller);
                products.put(productId, product);
                return new EntityResponse<Integer, Product>(HttpServletResponse.SC_OK, true, product);
            }else {
                return new ErrorResponse<Integer>(HttpServletResponse.SC_BAD_REQUEST, "Seller ID does not exist");
            }
        } catch (InvalidDataException ex) {
            return new ErrorResponse<Integer>(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
        }

    }

    @GetMapping("{id}")
    public Response show(@PathVariable int id) {
        if (products.containsKey(id)) {
            Product product = products.get(id);
            return new EntityResponse<Integer, Product>(HttpServletResponse.SC_OK, true, product);
        }else {
            return new ErrorResponse<Integer>(HttpServletResponse.SC_BAD_REQUEST, "ID not Found");
        }
    }
}
