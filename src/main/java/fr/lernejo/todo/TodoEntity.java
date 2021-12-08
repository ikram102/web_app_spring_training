package fr.lernejo.todo;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("todo")
public class TodoEntity {
    @Id
    public Long id;
    public String message;
    public String author;

    public TodoEntity(Long id, String message, String author) {
        this.id = id;
        this.message = message;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "TodoEntity{" +
            "id=" + id +
            ", message='" + message + '\'' +
            ", author='" + author + '\'' +
            '}';
    }

}

