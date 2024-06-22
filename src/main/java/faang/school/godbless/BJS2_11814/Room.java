package faang.school.godbless.BJS2_11814;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class Room {
    private List<Food> foods;
    private String name;

    public Room(String name) {
        this.name = name;
    }

    public void addFoodToRoom(Food... food) {
        if (foods == null) {
            foods = new ArrayList<>();
        }
        foods.addAll(Arrays.asList(food));
    }

    @Override
    public String toString() {
        return "Room{" +

                " name='" + name + '\'' +
                '}';
    }
}
