package andrei.model;

import andrei.data.TodoItemDAO;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Slf4j
public class TodoData {

    //immutable class
    private final TodoItemDAO todoItemDAO;

    public TodoData() {
        // add dummy data
/*        addItem(new TodoItem("first", "first details", LocalDate.now()));
        addItem(new TodoItem("second", "second details", LocalDate.now()));
        addItem(new TodoItem("third", "third details", LocalDate.now()));
        addItem(new TodoItem("fourth", "fourth details", LocalDate.now()));*/
        todoItemDAO = new TodoItemDAO();
    }

    public List<TodoItem> getItems(){
        List<TodoItem> items = todoItemDAO.findAll();
        items.sort(Comparator.comparingInt(TodoItem::getId));
        return Collections.unmodifiableList(items);
    }

    // use lombok non null annotation
    public void addItem(@NonNull TodoItem toAdd){
      todoItemDAO.insert(toAdd);
    }

    public void removeItem(int id){
        List<TodoItem> items = todoItemDAO.findAll();
        for (TodoItem item : items) {
            if (item.getId() == id) {
                todoItemDAO.delete(item);
                break;
            }
        }
    }
    public TodoItem getItem(int id){
        return todoItemDAO.findById(id);
    }

    public void updateItem(@NonNull TodoItem toUpdate){
        List<TodoItem> items = todoItemDAO.findAll();

        for (TodoItem item : items) {
            if (item.equals(toUpdate)) {
                todoItemDAO.update(toUpdate);
                break;
            }
        }
    }
}
