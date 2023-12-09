package faang.school.godbless.alexbulgakoff.gameofthrones;

import java.util.Map;

/**
 * @author Alexander Bulgakov
 */

public interface HouseService {
    void addHouse(House newHouse);

    void deleteHouseByName(String name);

    void searchHouse(String name);

    void getAllHouse(Map<String, House> houses);


}
