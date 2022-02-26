package co.com.sofka.crud.Service;

import co.com.sofka.crud.DTO.TodoListDTO;
import co.com.sofka.crud.Entity.ListTodo;
import co.com.sofka.crud.Entity.Todo;
import co.com.sofka.crud.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    public ArrayList<Todo> allTodo() {
        return (ArrayList<Todo>) todoRepository.findAll();
    }

    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    public Todo saveTodo(Todo todo) {
        if (todo.getName() == null){
            throw new RuntimeException("Ingrese un nombre");
        }
        return todoRepository.save(todo);
    }

    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }


    public Todo updateTodo(long id, Todo todo) {
        Optional<Todo> todoOk = todoRepository.findById(id);

        if (todoOk.isPresent()){
            Todo _todo = todoOk.get();
            Long listOk = _todo.getList().getId();
            Long newTodoListId = todo.getList().getId();


            if(!Objects.equals(listOk, newTodoListId)){
                throw new RuntimeException("No se puede cambiar");
            }
        }
        if(todo.getId() != null){
            return todoRepository.save(todo);
        }
        throw new RuntimeException("No se encontró el id");
    }

    public List<TodoListDTO> getAllTodoList() {
        return todoRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private TodoListDTO convertToDto (Todo todo){
        TodoListDTO todoDto = new TodoListDTO();
        todoDto.setIdToDo(todo.getId());
        todoDto.setCompleted(todo.isCompleted());
        todoDto.setNameToDo(todo.getName());
        todoDto.setIdList(todo.getList().getId());
        return todoDto;
    }
}
