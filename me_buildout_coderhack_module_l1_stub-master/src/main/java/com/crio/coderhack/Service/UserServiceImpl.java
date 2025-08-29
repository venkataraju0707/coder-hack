package com.crio.coderhack.Service;

import com.crio.coderhack.Model.Model;
import com.crio.coderhack.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Model createUser(Model user) {
        user.setScore(0);
        user.setBadges(new HashSet<>());
        return userRepository.save(user);
    }

    @Override
    public List<Model> getAllUsers() {
        List<Model> users = userRepository.findAll();
        users.sort(Comparator.comparingInt(Model::getScore));
        return users;
    }

    @Override
    public Optional<Model> getUserById(String userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Model updateUserScore(String userId, int score) {
        Optional<Model> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()) {
            Model user = userOpt.get();
            user.setScore(score);

            Set<String> badges = new HashSet<>();
            if (score >= 1) badges.add("CODE_NINJA");
            if (score >= 30) badges.add("CODE_CHAMP");
            if (score >= 60) badges.add("CODE_MASTER");

            List<String> sortedBadges = new ArrayList<>(badges);
            Collections.sort(sortedBadges);
            if (sortedBadges.size() > 3) {
                sortedBadges = sortedBadges.subList(0, 3);
            }

            user.setBadges(new HashSet<>(sortedBadges));
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
