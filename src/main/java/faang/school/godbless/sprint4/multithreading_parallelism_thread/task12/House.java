package faang.school.godbless.sprint4.multithreading_parallelism_thread.task12;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class House {

    private List<Room> rooms = new ArrayList<>();

    private List<Food> foods;

    public House() {
        initialize();
    }

    public void collectFood() {
        System.out.println("collectFood");
        foods = rooms.stream()
                .flatMap(x -> x.getFoods().stream())
                .toList();
        foods.forEach(System.out::println);
        System.out.println("Start remove food");
        rooms.clear();
        System.out.println("Done remove food");
        initialize();
    }

    private void initialize() {
        Room room1 = new Room(List.of(new Food("Яблоко"), new Food("Кукуруза")));
        Room room2 = new Room(List.of(new Food("Персик"), new Food("Сендвич")));
        rooms.add(room1);
        rooms.add(room2);
    }
}
