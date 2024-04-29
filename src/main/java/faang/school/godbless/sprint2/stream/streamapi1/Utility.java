package faang.school.godbless.sprint2.stream.streamapi1;

import java.util.List;

public class Utility {

    public static final String NULL_LIST_ERROR_MESSAGE = "The list cannot be null.";

    public static <T> void checkListNotNull(List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException(NULL_LIST_ERROR_MESSAGE);
        }
    }
}
