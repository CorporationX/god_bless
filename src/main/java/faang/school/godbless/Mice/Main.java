package faang.school.godbless.Mice;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Main {
    public static void main(String[] args) {
        Food apple = new Food("Яблоко");
        Food pear = new Food("Груша");
        Food sandwich = new Food("Бутерброд");
        Food juice = new Food("Сок");
        Room firstRoom = new Room();
        Room secondRoom = new Room();
        firstRoom.getFoodInRoom().add(apple);
        firstRoom.getFoodInRoom().add(pear);
        secondRoom.getFoodInRoom().add(sandwich);
        secondRoom.getFoodInRoom().add(juice);
        List<Room> allRooms = List.of(firstRoom, secondRoom);
        List<Food> allFoods = List.of(apple, pear, sandwich, juice);
        House house = new House(allRooms, allFoods);

        final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 6; i++) {
            executorService.schedule(house::findAllFood,30, SECONDS);
        }
        executorService.shutdown();
        try {
            if(executorService.awaitTermination(40, SECONDS)){
                System.out.println("\nЗадача выполнена!");
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
