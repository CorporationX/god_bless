package school.faang.mice_nice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Initialization initialization = new Initialization();
        House hotel = initialization.createHouse();

        System.out.println(hotel.getRooms());

    }
}
