package school.faang.task_44726;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RoomType {
    private static final List<String> ROOM_TYPE = Arrays.asList("single", "double", "suite");

    static Random random = new Random();

    public static String getRandomRoomType() {
        return ROOM_TYPE.get(random.nextInt(ROOM_TYPE.size()));
    }
}
