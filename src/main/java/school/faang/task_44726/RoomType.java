package school.faang.task_44726;

import java.util.Random;

public enum RoomType {
    SINGLE("Single"),
    DOUBLE("Double"),
    SUITE("Suite");

    private static final Random RANDOM = new Random();

    private String roomTypeName;

    RoomType(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    private String getTypeName() {
        return roomTypeName;
    }

    public static String getRandomRoomType() {
        RoomType[] roomTypes = RoomType.values();
        return roomTypes[RANDOM.nextInt(roomTypes.length)].getTypeName();
    }
}
