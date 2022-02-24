package co.com.sofka.crud.list;

import co.com.sofka.crud.todo.Todo;

import java.util.ArrayList;
import java.util.List;

public class ListModel {
    private Long id;
    private String name;
    Todo todos;

    public ListModel(String name, Todo todos) {
        this.name = name;
        this.todos = todos;
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

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }
}
