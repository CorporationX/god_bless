package faang.school.godbless.MiceAreNice;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Room {
    private List<Food> food;

    public List<Food> collectFood() {
        List<Food> temp = new ArrayList<>(food);
        temp.forEach(food1 -> System.out.println(food1.getName() + " - собрано"));
        food.clear();
        return temp;
    }
}
