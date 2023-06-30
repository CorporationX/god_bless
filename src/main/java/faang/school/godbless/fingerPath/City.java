package faang.school.godbless.fingerPath;

public class City {
  private String name;
  private Location location;

  public City(String name, Location location) {
    this.name = name;
    this.location = location;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public Location getLocation() {
    return location;
  }
}
