package andrei.service;

import andrei.model.TodoData;
import andrei.model.TodoItem;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class ToDoItemServiceImpl implements TodoItemService {
    @Getter
    private final TodoData data = new TodoData();
    @Override
    public void addItem(TodoItem toAdd) {
        data.addItem(toAdd);
    }

    @Override
    public void removeItem(int id) {
        data.removeItem(id);
    }

    @Override
    public TodoItem getItem(int id) {
        return data.getItem(id);
    }

    @Override
    public void updateItem(TodoItem toUpdate) {
            data.updateItem(toUpdate);
    }
}
