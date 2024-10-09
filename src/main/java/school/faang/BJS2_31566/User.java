package school.faang.BJS2_31566;

import lombok.Data;
import lombok.Getter;

import java.util.Set;

@Data
@Getter
public class User {

    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public User(int id, String name, int age, Set<String> activities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;
    }
}
