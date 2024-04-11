package doubleCache;

import lombok.Data;


@Data
public class Subject {
    private int id;
    private String name;
    private static int counterId = 1;

    public Subject(String name) {
        this.id = counterId;
        this.name = name;
        counterId++;
    }
}
