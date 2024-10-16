package school.faang.Multithreading.sprint_3.Mice;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Food {
    private final String name;

    public Food(String name){
        this.name = name;
    }
}
