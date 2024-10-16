package school.faang.miceareverynice.maincode;

import lombok.ToString;

@ToString
public class Food {
    private String foodName;

    public Food(String foodName) {
        this.foodName = foodName;
    }
}
