package school.faang.cash;

public record Student(String id, String name) {

  @Override
  public String toString() {
    return id + " " + name;
  }
}
