package fr.lernejo.todo;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Map;

@RestController
public class TodoListController {
    ArrayList<Todo> todoArrayList = new ArrayList<>();

    @PostMapping(value = "/api/todo")
    public void addTodoToTheList(@RequestParam("message") String message, @RequestParam("author") String author){
        this.todoArrayList.add(new Todo(message, author));
    }

    @GetMapping(value = "/api/todo")
    public @ResponseBody ArrayList<Todo> getTodoList(){
        return this.todoArrayList;
    }
}

