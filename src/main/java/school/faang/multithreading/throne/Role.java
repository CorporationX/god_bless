package school.faang.multithreading.throne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Role {

  private String name;
  private boolean isAvailable = true;

  public Role(String name) {
    this.name = name;
  }
}
