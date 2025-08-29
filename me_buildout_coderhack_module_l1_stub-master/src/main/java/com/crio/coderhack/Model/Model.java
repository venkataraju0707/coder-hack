package com.crio.coderhack.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.HashSet;
import java.util.Set;

@Document(collection = "users")
public class Model {

    @Id
    private String userId;
    private String user;
    private int score;
    private Set<String> badges = new HashSet<>();

    public Model() {
    }

    public Model(String userId, String user  ) {
        this.userId = userId;
        this.user = user;
        this.score = 0;
        this.badges = new HashSet<>();;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Set<String> getBadges() {
        return badges;
    }

    public void setBadges(Set<String> badges) {
        this.badges = badges;
    }

    
}
