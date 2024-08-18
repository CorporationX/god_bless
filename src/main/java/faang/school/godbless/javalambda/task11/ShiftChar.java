package faang.school.godbless.javalambda.task11;

@FunctionalInterface
public interface ShiftChar {
    char shift(char symbol, Integer encryptionKey, char startChar);
}
