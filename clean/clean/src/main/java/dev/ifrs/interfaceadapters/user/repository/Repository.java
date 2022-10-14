package dev.ifrs.interfaceadapters.user.repository;

import dev.ifrs.interfaceadapters.user.repository.entity.UserEntity;
import dev.ifrs.model.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public class Repository implements PanacheRepository<UserEntity> {
    
    public User save(User user){

        UserEntity entity = new UserEntity();
        entity.setName(user.getName());
        entity.setPassword(user.getPassword());
        persist(entity);

        return user;
        
    }

}
