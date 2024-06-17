package faang.school.godbless.bjs2_10870;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 * класс Рыцаря.
 */
@Data
public class Knight {

  private String name;
  private List<Trial> trials = new ArrayList<>();

  public Knight(String name) {
    this.name = name;
  }

  public void addTrial(Trial trial) {
    this.trials.add(trial);
  }

}
