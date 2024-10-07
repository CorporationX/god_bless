package school.faang.doublecachecache;

import lombok.Data;

@Data
public class Student {
    private static int idCounter = 0;
    private int id;
    private String name;

    public Student(String name) {
        this.id = ++idCounter;
        if (name.isEmpty()) {
            System.out.println("Name is not be empty!");
        }
        this.name = name;
    }
}
