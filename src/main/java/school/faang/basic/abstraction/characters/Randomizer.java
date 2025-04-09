package school.faang.basic.abstraction.characters;

import java.security.SecureRandom;
import java.util.List;

public class Randomizer {

    public static <T> T pickRandomMember(List<T> source) {
        int randomIndex = new SecureRandom().nextInt(0, source.size());
        return source.get(randomIndex);
    }
}