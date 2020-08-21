package com.oop.project.controller.endpoint;

import com.oop.project.controller.gestor.SingletonData;
import com.oop.project.controller.response.EntityResponse;
import com.oop.project.controller.response.ErrorResponse;
import com.oop.project.controller.response.ListResponse;
import com.oop.project.controller.response.Response;
import com.oop.project.model.product.Product;
import com.oop.project.model.user.Seller;
import com.oop.project.model.user.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sellers")
public class SellerController {

    SingletonData singletonData = SingletonData.getSingletonInstance();
    private Map<Integer, Product> products = singletonData.getProducts();
    private Map<Integer, User> users = singletonData.getUsers();

    @GetMapping()
    public ListResponse<Integer, User> index() {

        Map<Integer, User> sellers = products.entrySet().stream()
                .map(entry -> entry.getValue().getSeller().getId())
                .distinct()
                .collect(Collectors.toMap(map -> map, map -> users.get(map)));

        List<User> results = new ArrayList<>(sellers.values());
        ListResponse<Integer, User>  response = new ListResponse<Integer, User>(HttpServletResponse.SC_OK, true, results.size(), results);
        return response;
    }

    @GetMapping("{id}")
    public Response show(@PathVariable int id) {
        if (users.containsKey(id)) {
            List<Product> productsList = products.values().stream()
                .filter(x -> x.getSeller().getId() == id)
                .collect(Collectors.toList());
            if (productsList.isEmpty()) {
                return new ErrorResponse<Integer>(HttpServletResponse.SC_BAD_REQUEST, "Seller not Found");
            }
            User user = users.get(id);
            Seller seller = new Seller(user.getName(), user.getEmail(), productsList);
            return new EntityResponse<Integer, Seller>(HttpServletResponse.SC_OK, true, seller);
        }else {
            return new ErrorResponse<Integer>(HttpServletResponse.SC_BAD_REQUEST, "ID not Found");
        }
    }

}
