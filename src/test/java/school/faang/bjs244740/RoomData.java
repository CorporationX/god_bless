package school.faang.bjs244740;

import java.util.Set;

public enum RoomData {
    ROOM1(1, "", Set.of("1 bed", "fan", "tv")),
    ROOM2(2, "", Set.of("2 bed", "microwave", "tv")),
    ROOM3(3, "", Set.of("1 bed", "microwave", "fridge")),;

    RoomData(int roomId, String type, Set<String> amenities) {
        this.roomId = roomId;
        this.type = type;
        this.amenities = amenities;
    }

    private final int roomId;
    private final String type;
    private final Set<String> amenities;

    public Room createRoom() {
        return new Room(roomId, type, amenities);
    }

    public int getRoomId() {
        return roomId;
    }

    public String getType() {
        return type;
    }

    public Set<String> getAmenities() {
        return amenities;
    }
}
