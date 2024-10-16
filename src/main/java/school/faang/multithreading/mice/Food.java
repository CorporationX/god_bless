package school.faang.multithreading.mice;

public record Food(String name) {

  @Override
  public String toString() {
    return name;
  }
}
