package faang.school.godbless.kxnvg.tomandjerry;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
public class House {

    private List<Room> rooms;
    private List<Food> totalFood;

    public static void main(String[] args) {
        House house = new House();
        house.listInit();

        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);

        for (Room room : house.getRooms()) {
            service.schedule(() -> {
                house.getTotalFood().addAll(house.collectFood(room));
                room.setRoomFood(new ArrayList<>());
            }, 30, TimeUnit.SECONDS);
        }

        service.shutdown();
        try {
            service.awaitTermination(2, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("===   Вся еда в доме собрана   ===");
    }

    public List<Food> collectFood(Room room) {
        List<Food> resultList = new ArrayList<>();

        System.out.println("В комнате " + room.getName() + " началась сборка еды");
        for (Food food : room.getRoomFood()) {
            resultList.add(food);
            System.out.println(food.getName() + " собрана");
        }
        return resultList;
    }

    private void listInit() {
        totalFood = new ArrayList<>();
        rooms = new ArrayList<>();
        Room kitchen = new Room("Кухня");
        Room bedroom = new Room("Спальня");

        kitchen.setRoomFood(List.of(new Food("яйцо"), new Food("сахар"), new Food("молоко"),
                new Food("чипсы"), new Food("хлеб"), new Food("колбоса"), new Food("банан")));
        bedroom.setRoomFood(List.of(new Food("яблоко"), new Food("сыр"), new Food("шоколадка"),
                new Food("чай"), new Food("мороженное")));

        rooms.add(kitchen);
        rooms.add(bedroom);
    }
}
