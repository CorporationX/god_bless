package faang.school.godbless.module1.sprint2.task10;

@FunctionalInterface
public interface DroidMessageEncryptor<T, U, R> {
    R encrypt(T t, U u);
}
