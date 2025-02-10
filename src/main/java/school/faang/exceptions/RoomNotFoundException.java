package school.faang.exceptions;

public class RoomNotFoundException extends RuntimeException {
    public RoomNotFoundException(int roomNumber) {
        super("Room with ID " + roomNumber + " was not found.");
    }
}
