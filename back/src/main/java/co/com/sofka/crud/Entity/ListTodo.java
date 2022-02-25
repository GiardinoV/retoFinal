package co.com.sofka.crud.Entity;

import co.com.sofka.crud.Entity.Todo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ListTodo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Todo> Todos;

    public  ListTodo(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Todo> getTodos() {
        return Todos;
    }

    public void setTodos(Set<Todo> todos) {
        Todos = todos;
    }
}
