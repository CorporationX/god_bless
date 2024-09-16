package faang.school.godbless.BJS2_5164;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Character {
  private String name;
  private List<Item> inventory = new ArrayList<>();

  public Character(String name) {
    this.name = name;
  }
}
