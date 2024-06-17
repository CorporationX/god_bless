package faang.school.godbless.bjs2_12181;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PigThread extends Thread {
  protected static final String CONSTRUCTION_HOUSE_STARTED = "%s начал строительство дома из %s";
  protected static final String CONSTRUCTION_HOUSE_ENDED = "%s закончил строительство дома из %s";

  private String pigName;
  private String material;

  @Override
  public void run() {
    System.out.println(String.format(CONSTRUCTION_HOUSE_STARTED, this.pigName, this.material));
    try {
      Thread.sleep(MaterialType.findByType(this.material));
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println(String.format(CONSTRUCTION_HOUSE_ENDED, this.pigName, this.material));
  }
}
