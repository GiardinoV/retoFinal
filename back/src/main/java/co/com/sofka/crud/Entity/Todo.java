package co.com.sofka.crud.Entity;

import javax.persistence.*;

@Entity
public class Todo {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private boolean completed;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_list")
    private ListTodo list;

    public Todo(){
    }

    public Todo(Long id, String name, boolean completed, ListTodo list) {
        this.id = id;
        this.name = name;
        this.completed = completed;
        this.list = list;
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

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public ListTodo getList() {
        return list;
    }

    public void setList(ListTodo list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", completed=" + completed +
                ", list=" + list +
                '}';
    }
}
