package dev.ifrs.interfaceadapters.user.controller;

import javax.enterprise.context.RequestScoped;

import dev.ifrs.model.User;
import dev.ifrs.usecase.user.UseCase;
import dev.ifrs.usecase.user.UseCaseInterface;


@RequestScoped

public class UserController implements UserControllerInterface {

    private UseCaseInterface uc;

    public UserController(){
        this.uc = new UseCase();
    }

    @Override
    public User save(String name, String password) {
        return uc.save(name, password);
    }
    
}
