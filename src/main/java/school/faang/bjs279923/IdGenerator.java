package school.faang.bjs279923;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public final class IdGenerator {
    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.PRIVATE)
    private static int idSequence = 0;

    private IdGenerator() {}

    public static int generateId() {
        setIdSequence(getIdSequence() + 1);
        return getIdSequence();
    }
}