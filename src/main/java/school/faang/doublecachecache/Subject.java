package school.faang.doublecachecache;

import lombok.Data;

@Data
public class Subject {
    private static int idCounter;
    private int id;
    private String name;

    public Subject(String name) {
        this.id = ++idCounter;
        if (name.isEmpty()) {
            System.out.println("Subject is not be empty!");
        }
        this.name = name;
    }
}
