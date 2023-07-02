package faang.school.godbless.multithreading.mice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HouseTest {

    @Test
    void collectFood() {
        House house = new House();

        house.getRooms().forEach(room -> {
            System.out.println(room.getName());
            System.out.println(room.getFoodList());
        });

        long expected = house.getRooms().stream()
                .mapToLong(room -> room.getFoodList().size())
                .sum();
        System.out.println("Всего еды в доме: " + expected);

        for (int i = 0; i < house.getRooms().size() / 2; i++) {
            house.collectFood();
        }

        assertEquals(expected, house.getCollectedFood().size());
        house.getRooms().forEach(room -> assertTrue(room.getFoodList().isEmpty()));
    }
}