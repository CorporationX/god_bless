package school.faang.task_43972;

import java.util.List;

public class User {

    private long id;
    private String name;
    private int ag;
    private List<String> activity;

    public User(){
        this.id = Utility.getCurrentDateInMilliseconds();
    }
}
