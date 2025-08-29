package com.crio.coderhack.Controller;

import com.crio.coderhack.Model.Model;
import com.crio.coderhack.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coderhack/api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<Model>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Model> getUserById(@PathVariable String userId) {
        Optional<Model> user = userService.getUserById(userId);
        return user.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Model> createUser(@RequestBody Model user) {
        Model savedUser = userService.createUser(user);
        return ResponseEntity.ok(savedUser);  
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Model> updateUserScore(@PathVariable String userId, @RequestBody Model user) {
        Model updatedUser = userService.updateUserScore(userId, user.getScore());
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }
}
