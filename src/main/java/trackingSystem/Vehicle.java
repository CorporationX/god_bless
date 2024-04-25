package trackingSystem;

import lombok.Data;

@Data
public class Vehicle {
    private int id;
    private String number;
    private boolean status;
    private Location location;
    private static int counterId = 1;

    public Vehicle(boolean status, String number, Location location) {
        this.id = counterId;
        this.number = number;
        this.status = status;
        this.location = location;
        counterId++;
    }
}
