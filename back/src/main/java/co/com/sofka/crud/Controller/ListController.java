package co.com.sofka.crud.Controller;

import co.com.sofka.crud.Entity.ListTodo;
import co.com.sofka.crud.Repository.ListRepository;
import co.com.sofka.crud.Service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ListController {

    @Autowired
    private ListService listService;

    @Autowired
    private ListRepository listRepository;

    //Obtener lista
    @GetMapping(value = "api/list")
    public ResponseEntity<List<ListTodo>> getList(){
        List<ListTodo> allList = listService.allList();
        if(allList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(allList, HttpStatus.OK);
    }

    //Obtener lista por id
    @GetMapping(value = "api/{id}/list")
    public ResponseEntity<ListTodo> getListById(@PathVariable("id") Long id){
        Optional<ListTodo> _list = listRepository.findById(id);
        if(_list.isPresent()){
            return new ResponseEntity<>(_list.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Guardar lista
    @PostMapping(value = "api/list")
    public ResponseEntity<ListTodo> saveList(@RequestBody ListTodo listTodo){
        try{
            ListTodo _list = listService.saveList(listTodo);
            return new ResponseEntity<>(_list, HttpStatus.CREATED);
        } catch(Exception err){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "api/{id}/list")
    public void deleteListById(@PathVariable("id")Long id){
        listService.deleteListById(id);
    }

}
