package com.crio.coderhack.Service;

import com.crio.coderhack.Model.Model;
import java.util.List;
import java.util.Optional;

public interface UserService {
      
     
    Model createUser(Model user);
    List<Model> getAllUsers();
    Optional<Model> getUserById(String userId);
    Model updateUserScore(String userId, int score);
    void deleteUser(String userId);
}
