package school.faang.task_44726;

public class Main {

    private static final int INITIAL_NUMBER_OF_ROOM_FOR_TESTING_MY_APPLICATION = 10;

    static BookingSystem bookingSystem = new BookingSystem();

    public static void main(String[] args) {

        for (int i = 0; i < INITIAL_NUMBER_OF_ROOM_FOR_TESTING_MY_APPLICATION; i++) {
            bookingSystem.addRoom(Room.builder()
                    .type(RoomType.getRandomRoomType())
                    .amenities(Amenities.getSetOfAmenities())
                    .build()
            );
        }

        ConsoleInteraction.consoleInteraction();
    }
}
