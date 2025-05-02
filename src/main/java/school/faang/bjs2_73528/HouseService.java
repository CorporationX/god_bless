package school.faang.bjs2_73528;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
@Slf4j
public class HouseService {
    private final House house;

    public void collectFood() {

        // Получаем еду из первых двух комнат
        List<Food> foods = house.getRooms().stream()
                .sorted(Comparator.comparingInt(r -> ThreadLocalRandom.current().nextInt()))
                .limit(2)
                .flatMap(room -> room.foods().stream())
                .toList();

        log.info("Food list in house {} assembled {}", house.getName(), foods);
    }
}
