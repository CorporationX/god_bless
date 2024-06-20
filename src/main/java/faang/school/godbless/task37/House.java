package faang.school.godbless.task37;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
public class House {
    private List<Room> roomArrayList = new ArrayList<>();
    private List<Food > foodArrayList = new ArrayList<>();

    public static void main(String[] args) {
        House house = new House();
        house.getFoodArrayList().addAll(Arrays.asList(new Food("apple"),new Food("banana"),new Food("orange")));
        house.getRoomArrayList().addAll(Arrays.asList(new Room("kitchen"),new Room("bathroom"),new Room("toilet")));
        ScheduledExecutorService executors = Executors.newScheduledThreadPool(5);
        for(Room room : house.getRoomArrayList()) {
            executors.schedule(()->house.collectFood(room),1, TimeUnit.SECONDS);
        }
        executors.shutdown();
        System.out.println(house.getFoodArrayList());
    }
    public List<Food> collectFood(Room room){
            List<Food> foodList = room.getFood();
            if(foodList!=null&&!foodList.isEmpty()){
               this.getFoodArrayList().addAll(foodList);
        }
        return foodArrayList;
    }
}
