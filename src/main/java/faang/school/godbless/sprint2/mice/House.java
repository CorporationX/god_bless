package faang.school.godbless.sprint2.mice;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Evgenii Malkov
 */

@Getter
@Slf4j
public class House {
    private final List<Food> collectedFood = new ArrayList<>();
    private final List<Room> rooms;

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void collectFood() {
        for (int i = 0; i < 2; i++) {
            collectFood(getActualRoom());
        }
    }

    private void collectFood(Room room) {
        log.info("Начали сбор еды из комнаты: " + room.getRoomNumber());
        collectedFood.addAll(room.getFood());
        room.getFood().clear();
        log.info(String.format("Собрали еду из комнаты: %s. Теперь в комнате: %s", room.getRoomNumber(), room.getFood()));
    }

    private Room getActualRoom() {
        return rooms.stream()
                .filter((room) -> !room.getFood().isEmpty())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Нет больше комнат с едой"));
    }
}
