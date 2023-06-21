package faang.school.godbless.telegram;

@FunctionalInterface
public interface MessageFilter {
  public boolean filter(String message);
}
