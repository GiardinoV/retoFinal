package co.com.sofka.crud.Service;

import co.com.sofka.crud.Entity.ListTodo;
import co.com.sofka.crud.Entity.Todo;
import co.com.sofka.crud.Repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ListService {

    @Autowired
    ListRepository listRepository;

    public ArrayList<ListTodo> allList() {
        return (ArrayList<ListTodo>) listRepository.findAll();
    }

    public ListTodo saveList(ListTodo listTodo) {
        return listRepository.save(listTodo);
    }

    public void deleteListById(Long id) {
        listRepository.deleteById(id);
    }


}
