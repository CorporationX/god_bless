package faang.school.godbless.game;

import lombok.Data;

import java.util.List;

@Data
public class Character {
   private List<Item> inventory;
   private String name;

   public Character(String name) {
      this.name = name;
   }
}
