package com.oop.project.controller.endpoint;

import com.oop.project.controller.gestor.SingletonData;
import com.oop.project.controller.response.EntityResponse;
import com.oop.project.controller.response.ErrorResponse;
import com.oop.project.controller.response.ListResponse;
import com.oop.project.controller.response.Response;
import com.oop.project.common.exception.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.oop.project.model.user.User;

import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


@RestController
@RequestMapping("/users")
public class UserController {

    SingletonData singletonData = SingletonData.getSingletonInstance();
    private Map<Integer, User> users = singletonData.getUsers();
    private AtomicInteger id = singletonData.getUsersId();

    @GetMapping()
    public ListResponse<Integer, User> index() {
        List<User> results = new ArrayList<>(users.values());
        ListResponse<Integer, User>  response = new ListResponse<Integer, User>(HttpServletResponse.SC_OK, true, results.size(), results);
        return response;
    }

    @PostMapping("/create")
    public Response create(User user){
        try {
            user.validate();
            int userId = id.getAndIncrement();
            user.setId(userId);
            users.put(userId, user);
            EntityResponse<Integer, User> response = new EntityResponse<Integer, User>(HttpServletResponse.SC_OK, true, user);
            return response;
        } catch (InvalidDataException ex) {
            return new ErrorResponse<Integer>(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
        }

    }

    @GetMapping("{id}")
    public Response show(@PathVariable int id) {
        if (users.containsKey(id)) {
            User user = users.get(id);
            return new EntityResponse<Integer, User>(HttpServletResponse.SC_OK, true, user);
        }else {
            return new ErrorResponse<Integer>(HttpServletResponse.SC_BAD_REQUEST, "ID not Found");
        }
    }

}