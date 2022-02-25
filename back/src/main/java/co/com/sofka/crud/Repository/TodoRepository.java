package co.com.sofka.crud.Repository;

import co.com.sofka.crud.Entity.Todo;
import co.com.sofka.crud.todo.TodoModel;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {

    TodoModel updateById(Long listId, TodoModel todo);
}
