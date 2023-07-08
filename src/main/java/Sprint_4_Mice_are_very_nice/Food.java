package Sprint_4_Mice_are_very_nice;

import lombok.Data;

@Data
public class Food {
    private String foodName;

    public Food(String foodName) {
        this.foodName = foodName;
    }
}
