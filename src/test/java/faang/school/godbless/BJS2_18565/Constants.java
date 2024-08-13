package faang.school.godbless.BJS2_18565;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Constants {

    public static final User USER_1 = new User("Ivan", 32, "Place of work 1", "Address 1");
    public static final User USER_2 = new User("Anna", 23, "Place of work 2", "Address 2");
    public static final User USER_3 = new User("Maria", 32, "Place of work 3", "Address 3");
    public static final User USER_4 = new User("Michael", 44, "Place of work 4", "Address 4");
    public static final User USER_5 = new User("Irina", 23, "Place of work 5", "Address 5");

    public static final List<User> USER_LIST = List.of(USER_1, USER_2, USER_3, USER_4, USER_5);

    public static Map<Integer, List<User>> CORRECT_USER_MAP = new HashMap<>() {{
       put(32, List.of(USER_1, USER_3));
       put(23, List.of(USER_2, USER_5));
       put(44, List.of(USER_4));
    }};

    public static Map<Integer, List<User>> INCORRECT_USER_MAP = new HashMap<>() {{
        put(32, List.of(USER_1, USER_2, USER_3));
        put(23, List.of(USER_4, USER_5));
    }};
}
