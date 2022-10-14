package dev.ifrs.interfaceadapters.user.controller;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;

import dev.ifrs.interfaceadapters.user.repository.Repository;
import dev.ifrs.model.User;
import dev.ifrs.usecase.user.UseCase;
import dev.ifrs.usecase.user.UseCaseInterface;

@RequestScoped
@Transactional
public class UserController implements UserControllerInterface {

    private UseCaseInterface uc;
    private Repository repo;
    
    public UserController(){
        this.uc = new UseCase();
        this.repo = new Repository();
    }

    @Override
    public User save(String name, String password) {
        User user = uc.save(name, password);
        return repo.save(user);
    }
    
}
