package school.faang.task_61538;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
public class House {
    private final Random random = new Random();
    private final List<Room> rooms;

    public void collectFood() {
        int firstIndexRoom = random.nextInt(0, rooms.size() - 1);
        for (int i = 0; i < rooms.size(); i++) {

        }
    }
}
