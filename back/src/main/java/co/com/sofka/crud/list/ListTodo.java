package co.com.sofka.crud.list;

import co.com.sofka.crud.todo.Todo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ListTodo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Todo> Todos;

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
