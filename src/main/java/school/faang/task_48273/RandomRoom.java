package school.faang.task_48273;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
public class RandomRoom {
    @NonNull
    private final List<Room> rooms;
    private final ThreadLocalRandom random = ThreadLocalRandom.current();
    private int lastRandomIndex = -1;

    public synchronized Room getRandomRoom() {
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
