package co.com.sofka.crud.todo;

import co.com.sofka.crud.list.ListModel;
import co.com.sofka.crud.todo.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {

    Iterable<ListModel> allList();

    Iterable<ListModel> getListId(Long listId);

    ListModel newList(ListModel todo);

    TodoModel updateById(Long listId, TodoModel todo);
}
