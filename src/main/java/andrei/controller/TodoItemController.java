package andrei.controller;

import andrei.model.TodoData;
import andrei.model.TodoItem;
import andrei.service.TodoItemService;
import andrei.util.AttributeNames;
import andrei.util.Mappings;
import andrei.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;

@Controller
@Slf4j
public class TodoItemController {
    private final TodoItemService todoItemService;
    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    @ModelAttribute
    public TodoData todoData(){
        //return new TodoData(); // before service
        return todoItemService.getData();
    }

    // http://localhost:8080/
    @GetMapping({Mappings.HOME, "/"})
    public String welcome(){
        return ViewNames.HOME;
    }


    // http://localhost:8080/items
    @GetMapping(Mappings.ITEMS)
    public String items(){
        return ViewNames.ITEMS_LIST;
    }

    // http://localhost:8080/add_item
    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(@RequestParam (required = false, defaultValue = "-1")int id,
                              Model model){
        log.info("editing id = {}", id);
        TodoItem todoItem = todoItemService.getItem(id);
        if(todoItem == null) {
            todoItem = new TodoItem("","", Date.valueOf(LocalDate.now()));
        }
        model.addAttribute(AttributeNames.TODO_ITEM,todoItem);
        return ViewNames.ADD_ITEM;
    }
    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id){
        log.info("Removing todoItem with id = {}", id);
        todoItemService.removeItem(id);
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.VIEW_ITEM)
    public String viewItem(@RequestParam int id, Model model){
        TodoItem todoItem = todoItemService.getItem(id);
        model.addAttribute(AttributeNames.TODO_ITEM,todoItem);
        return ViewNames.VIEW_ITEM;
    }

    // add as a model attribute and spring will do
    // some dark magic to make add it. The name passed
    // should match the name supplied in the form
    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem){
        log.info("todoItem from form = {}", todoItem);
        // redirecting our view to another URL
        // using item mapping

        // if id is default  or 0
        if(todoItem.getId() == 0) todoItemService.addItem(todoItem);
        else{  // we update the item
            todoItemService.updateItem(todoItem);
        }
        return "redirect:/" + Mappings.ITEMS;
    }

}
