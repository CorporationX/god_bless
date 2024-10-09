package school.faang.cash;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Subject {

  private String id;
  private String name;

  @Override
  public String toString() {
    return "[ " + id + " " + name + " ]";
  }
}
