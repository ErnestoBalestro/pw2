/**
 * PW2 by Rodrigo Prestes Machado
 *
 * PW2 is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 *
*/
package dev.pw2.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class User extends PanacheEntity {

    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // name = nome da coluna que irá armazenar a chave estrangeira
    // na tabela Message (solução a partir da JPA 2)
    @JoinColumn(name = "user_id")
    private List<Mercado> messages;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Produto> channels;

    public User() {
        this.messages = new ArrayList<>();
        this.channels = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Mercado> getMessages() {
        return messages;
    }

    public void setMessages(List<Mercado> messages) {
        this.messages = messages;
    }

    public void addMessage(Mercado message) {
        this.messages.add(message);
    }

    public List<Produto> getChannels() {
        return channels;
    }

    public void setChannels(List<Produto> channels) {
        this.channels = channels;
    }

    public void addChannel(Produto channel) {
        this.channels.add(channel);
    }

    public void addProduto(Produto produto) {
    }

}
