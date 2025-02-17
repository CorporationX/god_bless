package school.faang.witchergeralt;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@AllArgsConstructor
public class CityWorker implements Runnable {
    private static final Map<Monster, Double> MONSTER_POSITIONS = new HashMap<>();
    private static final int COORDINATE_CASTLE_X = 0;
    private static final int COORDINATE_CASTLE_Y = 0;
    private static final String PRINT_FORMAT = """
            
            Distance from castle to city: {}
            Nearliest monster: {}
            Coordinate: ({};{}), distance from city to monster: {}
            """;

    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        int cityX = city.getLocation().getCoordinateX();
        int cityY = city.getLocation().getCoordinateY();
        double distanceFromCastleToCity = calculateDistance(COORDINATE_CASTLE_X, COORDINATE_CASTLE_Y, cityX, cityY);
        monsters.forEach(monster -> MONSTER_POSITIONS.put(monster, calculateDistance(cityX,
                        cityY, monster.getLocation().getCoordinateX(),
                        monster.getLocation().getCoordinateY())));
        MONSTER_POSITIONS.entrySet().stream().sorted(Map.Entry.comparingByValue()).limit(1)
                .forEach(entry -> log.info(PRINT_FORMAT, Math.round(distanceFromCastleToCity),
                        entry.getKey().getName(), entry.getKey().getLocation().getCoordinateX(),
                        entry.getKey().getLocation().getCoordinateY(), entry.getValue().intValue()));
    }

    public double calculateDistance(int coordinateX, int coordinateY, int coordinateTargetX, int coordinateTargetY) {
        int differenceX = coordinateTargetX - coordinateX;
        int differenceY = coordinateTargetY - coordinateY;
        return Math.sqrt(differenceX * differenceX + differenceY * differenceY);
    }
}
