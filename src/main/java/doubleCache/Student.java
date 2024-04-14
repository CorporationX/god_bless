package doubleCache;

import lombok.Data;


@Data
public class Student {
    private int id;
    private String name;
    private static int counterId = 1;

    public Student(String name) {
        this.id = counterId;
        this.name = name;
        counterId++;
    }
}
