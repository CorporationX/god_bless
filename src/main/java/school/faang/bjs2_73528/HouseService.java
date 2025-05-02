package school.faang.bjs2_73528;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class HouseService {
    private final House house;

    public void collectFood() {
        List<Food> foods = house.rooms()
                .stream()
                .limit(2)
                .flatMap(room -> room.foods().stream())
                .toList();
        log.info("Food list in house {} assembled {}", house.name(), foods);
    }
}
