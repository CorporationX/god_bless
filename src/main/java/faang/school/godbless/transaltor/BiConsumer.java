package faang.school.godbless.transaltor;

/**
 * @author Evgenii Malkov
 */
public interface BiConsumer<T, K> {
  void doAction(T first, K second);
}
