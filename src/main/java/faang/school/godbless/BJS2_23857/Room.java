package faang.school.godbless.BJS2_23857;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Room {
    private List<Food> foodList = new ArrayList<>();

    public void collectFood() {
        System.out.println("Starting to collect food");
        foodList.forEach(food -> System.out.println("Collected" + food.getDescription()));
        System.out.println("All food from the room were collected");
    }
}
