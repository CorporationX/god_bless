package school.faang.bjs_68394;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

@Setter
@Getter
@ToString
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers() {
        Map<Integer, List<User>> group = new HashMap<>();
        return group;
    }
}




