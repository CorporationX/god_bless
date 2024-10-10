package school.faang.cash;

public record Subject(String id, String name) {

  @Override
  public String toString() {
    return "[ " + id + " " + name + " ]";
  }
}
