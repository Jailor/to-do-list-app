package andrei.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;

@Data
@EqualsAndHashCode(of = "id")
public class TodoItem{
    private int id;
    private String title;
    private String details;
    private Date deadline;

    public TodoItem(String title, String details, Date deadline) {
        this.id = 0;
        this.title = title;
        this.details = details;
        this.deadline = deadline;
    }


    public TodoItem(){}
}
