package faang.school.godbless.fingerPath;

public class Location {
  private float x;
  private float y;

  public Location(float x, float y) {
    this.x = x;
    this.y = y;
  }

  public static int getDistance(Location firstLocation, Location secondLocation) {
    return Math.round(firstLocation.x - secondLocation.x + firstLocation.y - secondLocation.y);
  }
}
