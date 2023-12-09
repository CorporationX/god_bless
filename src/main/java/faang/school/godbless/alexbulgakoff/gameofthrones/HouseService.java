package faang.school.godbless.alexbulgakoff.gameofthrones;

import java.util.List;
import java.util.Map;

/**
 * @author Alexander Bulgakov
 */

public interface HouseService {
    void addHouse(House newHouse);

    void deleteHouseByName(String name);

    String searchHouse(String name);

    List<Map<String, House>> getAllHouse();

}
