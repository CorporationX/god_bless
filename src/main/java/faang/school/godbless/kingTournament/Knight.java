package faang.school.godbless.kingTournament;

import java.util.ArrayList;
import java.util.List;

public class Knight {
  private String name;
  private List<Trial> trials = new ArrayList<>();

  public Knight(String name) {
    this.name = name;
  }

  public void addTrial(Trial trial) {
    trials.add(trial);
  }

  public String getName() {
    return name;
  }

  public List<Trial> getTrials() {
    return trials;
  }
}
