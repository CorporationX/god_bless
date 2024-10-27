package school.faang.async.amazon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Order {

  private int id;
  private String status;

  @Override
  public String toString() {
    return "Order #" + id + " status: " + status;
  }
}
