package school.faang.lord;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Character {

  private String name;
  private List<Item> inventory = new ArrayList<>();

  public Character(String name) {
    this.name = name;
  }
}
