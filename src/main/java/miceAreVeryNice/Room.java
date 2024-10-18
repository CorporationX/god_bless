package miceAreVeryNice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Room {
    private String name;
    private List<Food> foods;

    public boolean isEmptyRoom() {
        return this.getFoods().isEmpty();
    }

    public void clearRoom() {
        this.getFoods().clear();
    }
}
