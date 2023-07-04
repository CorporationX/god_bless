package faang.school.godbless.mags;

public class Student {
  private String name;
  private String year;
  private int points;

  public Student(String name, int points) {
    this.name = name;
    this.points = points;
  }

  public int getPoints() {
    return points;
  }

  public void setPoints(int points) {
    this.points = points;
  }
}
