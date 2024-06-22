package faang.school.godbless.sprint2.lordOfRings;


import java.util.function.Predicate;

public final class ValidatorUtils {

    private ValidatorUtils() {}

    public static boolean isValidCharacter(Character character) {
        return character != null;
    }

    public static boolean isValidPredicate(Predicate predicate) {
        return predicate != null;
    }

    public static boolean isValidItem(Item item) {
        return item != null;
    }
}
