package co.com.sofka.crud.Controller;

import co.com.sofka.crud.DTO.TodoListDTO;
import co.com.sofka.crud.Entity.ListTodo;
import co.com.sofka.crud.Entity.Todo;
import co.com.sofka.crud.Repository.TodoRepository;
import co.com.sofka.crud.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @Autowired
    private TodoRepository todoRepository;

    //Obtener todos los ToDos
    @GetMapping(value = "api/todo")
    public List<TodoListDTO> getAllTodo(){
        return todoService.getAllTodoList();
    }

    //Obtener ToDos por id
    @GetMapping(value = "api/{id}/todo")
    public Optional<Todo> get(@PathVariable("id") Long id){
        return todoService.getTodoById(id);
    }

    //Guardar ToDos
    @PostMapping(value = "api/todo")
    public ResponseEntity<Todo> saveTodo(@RequestBody Todo todo){
        try{
            Todo _todo = todoService.saveTodo(todo);
            return new ResponseEntity<>(_todo, HttpStatus.CREATED);
        } catch(Exception err){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    //Modificar Todos
    @PutMapping(value = "api/{listId}/todo")
    public ResponseEntity<ListTodo> updateTodo(@PathVariable("id") long id, @RequestBody Todo todo){
        try {
            Todo newTodo= todoService.updateTodo(id, todo);
            return new ResponseEntity<>(newTodo, HttpStatus.OK);
        } catch (Exception e){
            System.out.println("No se puede modificar");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    //Eliminar Todos
    @DeleteMapping(value = "api/{id}")
    public void deleteById(@PathVariable("id")Long id){
        todoService.deleteTodoById(id);
    }

}
