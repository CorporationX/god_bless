package faang.school.godbless.sprint2.streamAPI2;

import java.util.Collection;
import java.util.Map;

public final class ValidationUtils {

    private ValidationUtils() {}

    public static boolean isValidCollection(Collection collection) {
        return isCollectionNonNull(collection);
    }

    public static boolean isValidMap(Map map) {
        return isMapNonNull(map);
    }

    public static boolean isCollectionNonNull(Collection collection) {
        return collection != null;
    }

    public static boolean isMapNonNull(Map map) {
        return map != null;
    }

    public static boolean isValidIntegerRangeValues(Integer start, Integer end) {
        return (start != null && end != null) && start <= end;
    }
}
