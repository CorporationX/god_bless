package multithreadingPart1.mice;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
public class House {
    private List<Room> rooms ;
    private List<Food> foods ;

    public void addFoodFromRoom(int roomNumber, Food food){
        if(roomNumber < rooms.size()){
            rooms.get(roomNumber).getFoods().add(food);
        }else{
            System.out.println("Такой комнаты нету");
        }
    }
    public void collectFood(){
        Random rnd = new Random();
        int room1Index = rnd.nextInt(rooms.size());
        int room2Index = rnd.nextInt(rooms.size());
        while(room1Index == room2Index){
            room2Index = rnd.nextInt(rooms.size());
        }
        Room room1 = rooms.get(room1Index);
        Room room2 = rooms.get(room2Index);

        List<Food> foodsList = new ArrayList<>();

        room1.getFoods().forEach(food -> {
            foodsList.add(food);
            room1.getFoods().remove(food);
        });
        room2.getFoods().forEach(food -> {
            if(!foodsList.contains(food)){
                foodsList.add(food);
            }
            room2.getFoods().remove(food);
        });
        foods = foodsList;
    }

    public static void main(String[] args) {
        Food banana = new Food("banana");
        Food apple = new Food("apple");
        Food cherry = new Food("cherry");
        Food chiken = new Food("chiken");

        Room room1 = new Room();
        Room room2 = new Room();

        room1.getFoods().add(banana);
        room1.getFoods().add(apple);

        room2.getFoods().add(cherry);
        room2.getFoods().add(chiken);

        House house = new House();

        house.getRooms().add(room1);
        house.getRooms().add(room2);

        ScheduledExecutorService executors = Executors.newScheduledThreadPool(5);

        for(int i = 0; i < 5; i++){
            executors.schedule(() -> {
                            house.collectFood();
                            System.out.println("Сбор еды начат");
                        }, 500, TimeUnit.MILLISECONDS);
        }
        executors.shutdown();
        if(executors.isShutdown()){
            System.out.println("Еда собрана");
        }else{
            executors.shutdownNow();
        }
        System.out.println(room1.getFoods());
    }

}
