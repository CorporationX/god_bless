package school.faang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Задача гугл мэпс
        LocationSearchEngine engine = new LocationSearchEngine();

        List<Location> locations = new ArrayList<>(Arrays.asList(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704)
        ));
        List<Location> filteredLocations = engine.filterLocation(locations,
                (location) -> location.getLongitude() > 0);
        engine.processLocations(filteredLocations,
                (location) -> System.out.printf("Локация: %s\n", location.getName()));

        double baseLatitude = 37.4220;
        double baseLongitude = -122.0841;
        List<Double> distances = engine.calculateDistances(locations, (location) -> {
            double latitudeDiff = Math.abs(location.getLatitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.getLongitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        });

        engine.processDistances(distances,
                (distance) -> System.out.printf("Distance: %.2f\n", distance));
        // Задача обрабатываем ошибки красиво
        RemoteService remoteService = new RemoteService();
        ExceptionHandler exceptionHandler = new ExceptionHandler();

        String result = exceptionHandler.withErrorHandling(
                () -> remoteService.call("some Param"),
                e -> {
                    System.out.printf("Ошибка при вызове сервиса: %s\n", e.getMessage());
                    return e.getMessage();
                }
        );
        System.out.println(result);
        
        // Задача Lord of the Rings
        InventoryManager manager = new InventoryManager();

        Character frodo = new Character("Frodo");
        Item ring = new Item("The one Ring", 1000);

        manager.addItem(frodo, ring, (item) ->
                System.out.printf("Предмет: %s был добавлен в инвентарь\n", item.getName()));
        manager.removeItem(frodo, (item) -> item.getName().equals("The one Ring"));

        manager.addItem(frodo, ring, (item) ->
                System.out.printf("Предмет: %s cнова был добавлен в инвентарь\n", item.getName()));
        manager.updateItem(frodo, (item) -> item.getName().equals("The one Ring"),
                (item) -> new Item(item.getName(), item.getValue() * 2));

        System.out.println(frodo.getInventory().get(0).getValue());
    }
}
