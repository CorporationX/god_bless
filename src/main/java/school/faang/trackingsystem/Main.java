package school.faang.trackingsystem;

public class Main {
    private static final int COUNT_CAR = 10;
    private static final int TIME_TO_WORK = 10_000;
    private static final Location BASE = new Location(0.0, 0.0);

    public static void main(String[] args) {
        TransportManagementSystem system = new TransportManagementSystem();

        for (int i = 0; i < COUNT_CAR; i++) {
            system.addVehicle(new Vehicle(i, Status.PARKING, BASE));
        }

        system.start();

        try {
            Thread.sleep(TIME_TO_WORK);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        system.stop();

        for (int i = 0; i < COUNT_CAR; i++) {
            Status status = system.getVehicleInfo(String.valueOf(i)).getStatus();
            Location location = system.getVehicleInfo(String.valueOf(i)).getLocation();
            System.out.printf("Транспортное средство %d имеет статус %s находится в точке (%.3f; %.3f)\n"
                    , i, status, location.getLatitude(), location.getLongitude());
        }
    }
}