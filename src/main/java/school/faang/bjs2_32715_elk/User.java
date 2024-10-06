package school.faang.bjs2_32715_elk;

import lombok.Data;

@Data
public class User {
    private static int countId = 1;

    private final int id;
    private final String name;

    public User(String name){
        this.id = countId++;
        this.name = name;
    }
}
