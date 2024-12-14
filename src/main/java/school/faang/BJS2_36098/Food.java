package school.faang.BJS2_36098;

import lombok.Data;

@Data
public class Food {
    private String name;

    public Food(String name) {
        this.name = name;
    }
}
