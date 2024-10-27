package BJS2_36187;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Food {
    private String foodName;

    @Override
    public String toString() {
        return foodName;
    }
}
