package school.faang.cash;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student {

  private String id;
  private String name;

  @Override
  public String toString() {
    return id + " " + name;
  }
}
