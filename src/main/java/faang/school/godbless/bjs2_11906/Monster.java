package faang.school.godbless.bjs2_11906;

import static faang.school.godbless.bjs2_11906.Utils.getHabitatLocation;

import lombok.Data;

@Data
public class Monster extends Unit {

  private City city;
  private int habitatDistance;
  private long monsterPower;
  private Boolean isDefeated;

  public Monster(String name, City city, int maxHabitatDistance, long monsterPower) {
    super(name, getHabitatLocation(city.location(), maxHabitatDistance));
    this.city = city;
    this.habitatDistance = maxHabitatDistance;
    this.monsterPower = monsterPower;
    this.isDefeated = Boolean.FALSE;
  }

  public void setMonsterHabitatLocation(Location habitatLocation) {
    final Location newLocation= getHabitatLocation(habitatLocation, this.habitatDistance);
    this.setLocation(newLocation);
  }

}
