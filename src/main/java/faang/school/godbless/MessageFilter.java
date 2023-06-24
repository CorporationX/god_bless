package faang.school.godbless;

@FunctionalInterface
public interface MessageFilter {
  Boolean filter(String massage);
}
