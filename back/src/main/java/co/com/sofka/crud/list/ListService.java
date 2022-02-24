package co.com.sofka.crud.list;

import co.com.sofka.crud.todo.Todo;
import co.com.sofka.crud.todo.TodoModel;
import co.com.sofka.crud.todo.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Optional;
import java.util.Set;

@Service
public class ListService implements TodoRepository{

    @Autowired
    private TodoRepository repository;

    public Todo save(Todo todo){
        return repository.save(todo);
    }

    public Todo get(Long id){
         return repository.findById(id).orElseThrow();
    }

    @Override
    public Iterable<ListModel> allList() {
        return repository.allList();
    }

    @Override
    public Iterable<ListModel> getListId(Long listId) {
        return repository.getListId(listId);
    }

    @Override
    public ListModel newList(ListModel todo) {
        return repository.newList(todo);
    }

    public ListModel addTodo(Todo todo) {
        return ListModel(todo);
    }

    @Override
    public TodoModel updateById(Long listId, TodoModel todo) {
        return null;
    }

    @Override
    public <S extends Todo> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Todo> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Todo> findAll() {
        return null;
    }

    @Override
    public Iterable<Todo> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(Todo todo) {

    }

    @Override
    public void deleteAll(Iterable<? extends Todo> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
