package school.faang.mice_nice;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Room room = new Room(new ArrayList<>());
        room.addFood();
        System.out.println(room.getFoods());
    }
}
