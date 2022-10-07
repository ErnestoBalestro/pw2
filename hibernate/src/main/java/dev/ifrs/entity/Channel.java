package dev.ifrs.entity;

import java.util.ArrayList;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Channel extends PanacheEntity {

    private String hash;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private List<Message> messages;

    // construtor
    public Channel () {
        this.messages = new ArrayList<>();
    }

    public void addMessage(Message message){
        this.messages.add(message);
    }
    
}
