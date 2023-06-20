package faang.school.godbless.meta;

@FunctionalInterface
public interface Consumer<T> {
  public void handle(T notification);
}
