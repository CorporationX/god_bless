package faang.school.godbless.bjs2_9022;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Character {

  private String name;
  private List<Item> inventory = new ArrayList<>();

  public Character(String name) {
    this.name = name;
  }
}
