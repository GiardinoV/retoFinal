package co.com.sofka.crud.Repository;

import co.com.sofka.crud.Entity.ListTodo;
import org.springframework.data.repository.CrudRepository;

public interface ListRepository extends CrudRepository<ListTodo, Long> {
    Iterable<ListModel> allList();

    Iterable<ListModel> getListId(Long listId);

    ListModel newList(ListModel todo);
}
