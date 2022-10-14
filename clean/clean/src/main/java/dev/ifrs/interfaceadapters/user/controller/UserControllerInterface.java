package dev.ifrs.interfaceadapters.user.controller;

import dev.ifrs.model.User;

public interface UserControllerInterface {
    
    public User save(String name, String password);

}
