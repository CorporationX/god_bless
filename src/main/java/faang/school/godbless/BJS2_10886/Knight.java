package faang.school.godbless.BJS2_10886;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Knight {
  private String name;
  private List<Trial> trials = new ArrayList<>();

  public Knight(String name) {
    this.name = name;
  }

  public void addTrial(Trial trial) {
    trials.add(trial);
  }

  public void startTrials() {
    for (Trial trial : trials) {
      trial.run();
    }
  }
}
