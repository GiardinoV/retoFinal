package co.com.sofka.crud.Repository;

import co.com.sofka.crud.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
