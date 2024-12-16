package school.faang.sprint2.task_6;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private String name;
    private String email;

    public String print(@NonNull String words) {
        return ("User " + this.getName() + " says " + words);
    }
}
