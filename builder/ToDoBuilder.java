package builder;

import model.Deadline;
import model.ToDo;

public class ToDoBuilder {
    
    private ToDo todo;

    public ToDoBuilder() {
        todo = new ToDo();
    }
    
    public ToDoBuilder setName(String name) {
        this.todo.setName(name);
        return this;
    }

    public ToDoBuilder setDeadline(Deadline deadline) {
        this.todo.setDeadline(deadline);
        return this;
    }

    public ToDo build() {
        return todo;
    }
}
