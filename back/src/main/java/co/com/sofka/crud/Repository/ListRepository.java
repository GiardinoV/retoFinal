package co.com.sofka.crud.Repository;

import co.com.sofka.crud.Entity.ListTodo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListRepository extends JpaRepository<ListTodo, Long> {
}
