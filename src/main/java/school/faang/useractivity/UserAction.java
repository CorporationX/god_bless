package school.faang.useractivity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserAction {
    private int id;
    private String name;
    private String post;
    private Object date;
    private String content;
}
