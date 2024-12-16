package school.faang.task_48273;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
public class RandomRoom {
    @NonNull
    private final List<Room> rooms;
    private final Random random = new Random();
    private int lastRandomIndex = -1;

    public Room getRandomRoom() {
        if (rooms.isEmpty()) {
            throw new IllegalStateException("Rooms cannot be empty");
        }

        int randomIndex;
        do {
            randomIndex = random.nextInt(rooms.size());
        } while (randomIndex == lastRandomIndex);

        lastRandomIndex = randomIndex;
        return rooms.get(randomIndex);
    }
}
