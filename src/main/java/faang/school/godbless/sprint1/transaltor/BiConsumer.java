package faang.school.godbless.sprint1.transaltor;

/**
 * @author Evgenii Malkov
 */
public interface BiConsumer<T, K> {
  void doAction(T first, K second);
}
