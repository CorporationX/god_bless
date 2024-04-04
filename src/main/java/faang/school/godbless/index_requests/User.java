package faang.school.godbless.index_requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private static int startId = 0;
    private int id;
    private String name;

    public User(String name) {
        this.id = startId++;
        this.name = name;
    }

}
