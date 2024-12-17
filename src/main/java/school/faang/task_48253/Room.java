package school.faang.task_48253;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class Room {
    private final List<Food> foods = new ArrayList<>();
    private Lock lock = new ReentrantLock();

    public boolean hasFood(){
        return !foods.isEmpty();
    }
}
