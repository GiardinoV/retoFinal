package co.com.sofka.crud.list;

import co.com.sofka.crud.todo.Todo;
import co.com.sofka.crud.todo.TodoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ListController {

    private ListService service;

    @Autowired
    public ListController(ListService service){
        this.service = service;
    }

    @GetMapping(value = "api/todo")
    public Iterable<Todo> get(){
        return service.findAll();
    }

    @GetMapping(value = "api/{id}/todo")
    public Todo get(@PathVariable("id") Long id){
        return service.get(id);
    }

    @GetMapping(value = "api/list")
    public Iterable<ListModel> allList(){
        return service.allList();
    }

    @GetMapping(value = "api/{listId}/list")
    public Iterable<ListModel> getListId(@PathVariable("listId") Long listId){
        return service.getListId(listId);
    }

    @PostMapping(value = "api/todo")
    public Todo newTodo(@RequestBody Todo todo){
        if(todo.getName().length() < 2 || todo.getName() == null){
            throw new RuntimeException("Ingrese un nombre válido");
        }
        return service.save(todo);
    }
    
    @PostMapping(value = "api/list")
    public ListModel newList(@RequestBody ListModel todoList){
        return service.newList(todoList);
    }

    /*@PostMapping(value = "api/list/addTodo")
    public ListModel addTodo(@RequestBody Todo todo){
        ListTodo listModel = service.save(new ListTodo(todo.setName(todo.getName()),todo.se;));
        return service.addTodo(todo);
    }  */

    @PutMapping(value = "api/{listId}/todos")
    public TodoModel updateById(@PathVariable("listId") Long listId, @RequestBody TodoModel todo){
        if(todo.getId() != null){
            return service.updateById(listId, todo);
        }
        throw new RuntimeException("No existe el id para actualizar");
    }

    @DeleteMapping(value = "api/{id}")
    public void deleteById(@PathVariable("id")Long id){
        service.deleteById(id);
    }


}
