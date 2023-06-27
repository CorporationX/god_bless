package faang.school.godbless.Mice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@AllArgsConstructor
@Getter
public class House implements Runnable{
    @NonNull
    private List<Room> rooms;
    @NonNull
    private List<Food> foods;

    @Override
    public void run() {

    }

    public void findAllFood(){
        List<Food> result = new ArrayList<>();
        for (Room room : rooms){
            synchronized (room) {
                result.addAll(room.getFoodInRoom());
                room.setFoodInRoom(new ArrayList<>());
            }
        }
        for (Food food : result){
            System.out.print("'" + food + "', ");
        }
    }
}
