package faang.school.godbless.bjs2_11906;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class Witcher extends Unit {

  private String witcherSchool;
  private List<Monster> monstersDefeated = new ArrayList<>();
  private List<City> citiesVisited = new ArrayList<>();

  public Witcher(String name, Location location, String witcherSchool) {
    super(name, location);
    this.witcherSchool = witcherSchool;
  }
}
