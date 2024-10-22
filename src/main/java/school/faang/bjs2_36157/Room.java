package school.faang.bjs2_36157;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class Room {
   private final List<Food> foodList;

   public Room(List<Food> foodList) {
      this.foodList = foodList;
   }
}
