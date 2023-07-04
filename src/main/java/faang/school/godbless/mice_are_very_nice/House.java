package faang.school.godbless.mice_are_very_nice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


@Getter
@Setter
public class House {
    private List<Room> rooms = new ArrayList<>();
    private List<Food> foods = new ArrayList<>();


    public synchronized void collectFood() {
        for(int i = 0; i < 2; i++) {
            List<Food> foodsInRoom = rooms.get(i).getFoodsInRoom();
            for(int j = 0; j < foodsInRoom.size(); j++) {
            foods.add(foodsInRoom.get(j));
        }
            rooms.remove(rooms.get(i));
            rooms.add(null);
        }
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }
}
