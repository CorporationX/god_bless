package school.faang.bjs279766;

import lombok.Getter;
import lombok.Setter;

public final class IdGenerator {
    @Getter
    @Setter
    private static int idSequence = 0;

    public static int generateId() {
        setIdSequence(getIdSequence() + 1);
        return getIdSequence();
    }
}
