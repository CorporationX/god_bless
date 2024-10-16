package school.faang.BJS2_36098;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.Arrays.*;

@Data
public class House {
    private List<Room> rooms;

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public static void main(String[] args) {
        ArrayList<Food> kitchenFood = new ArrayList<>(asList(
                "бекон",
                "мясо",
                "яйца"
        ));

        ArrayList<String> livingFood = new ArrayList<>(asList(
                "шоколад",
                "вода",
                "молоко"
        ));

        ArrayList<String> bathroomFood = new ArrayList<>();

        ArrayList<String> todRoomFood = new ArrayList<>(asList(
                "чипсы",
                "водка",
                "творог"
        ));
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(kitchenFood));
        rooms.add(new Room(livingFood));
        rooms.add(new Room(bathroomFood));
        rooms.add(new Room(todRoomFood));

        House house = new House(rooms);

        ExecutorService executor = Executors.newScheduledThreadPool(5);

        for(int i = 0; i < 5; i++){
            executor.submit(() -> house.collectFood
        }

    }
}
