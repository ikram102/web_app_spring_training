package fr.lernejo.todo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TodoListController {
    private final TodoRepository todoRepository;

    public TodoListController(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    @PostMapping(value = "/api/todo")
    public @ResponseBody TodoEntity addTodoToTheBdd(@RequestBody Todo todo){
        return this.todoRepository.save(new TodoEntity(null, todo.message(), todo.author()));
    }

    @GetMapping(value = "/api/todo")
    public @ResponseBody Iterable<Todo> getTodoList(){
        Iterable<TodoEntity> todoEntityIterable = this.todoRepository.findAll();
        ArrayList<Todo> todoArrayList = new ArrayList<>();
        for (TodoEntity todo : todoEntityIterable) {
            todoArrayList.add(new Todo(todo.message, todo.author));
        }
        return todoArrayList;
    }
}
