package mice;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Room {
    @Getter
    private final String roomName;
    private final List<Food> foods = new ArrayList<>();
    private final Random rand = new Random();

    public Room(@NonNull String roomName, @NonNull List<Food> foods) {
        this.roomName = roomName;
        this.foods.addAll(foods);
    }

    public void addFood(@NonNull Food food) {
        foods.add(food);
    }

    public Optional<Food> collectSomeFoodFromRoom() {
        try {
            return Optional.of(foods.remove(rand.nextInt(foods.size())));
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }

    public boolean isRoomHasFood() {
        return !foods.isEmpty();
    }
}
