package com.example.mobilele.security;

import com.example.mobilele.Model.Enums.Role;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class CurrentUser {
    private static final String ANONYMOUS = "anonymous";
    private String name = ANONYMOUS;
    private boolean isAnonymous = true;
    private List<Role> userRoles = new ArrayList<>();

    public CurrentUser() {
    }

    public CurrentUser setUserRoles(List<Role> roles) {

        userRoles.clear();
        userRoles.addAll(roles);
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLoggedIn() {
        return !isAnonymous;
    }

    public boolean isAdmin(){
        return userRoles.contains(Role.Admin);
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }

    public void setAnonymous(boolean anonymous) {
        if (anonymous) {
            this.name = ANONYMOUS;
            this.userRoles.clear();
        }
        isAnonymous = anonymous;
    }
}
