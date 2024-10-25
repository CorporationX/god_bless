package school.faang.bjs2_36157;

import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Getter
@ToString
public class Room {
   private final List<Food> foodList;
   private final ReentrantLock lock = new ReentrantLock();

   public Room(List<Food> foodList) {
      this.foodList = foodList;
   }
}
