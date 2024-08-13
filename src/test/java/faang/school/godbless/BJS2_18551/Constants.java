package faang.school.godbless.BJS2_18551;

import java.util.*;

public class Constants {

    public static final Set<String> ACTIVITIES_1 = new HashSet<>() {{
       add("Swimming");
       add("Programming");
       add("Cooking");
    }};

    public static final Set<String> ACTIVITIES_2 = new HashSet<>() {{
        add("Dance");
        add("Running");
        add("Yoga");
        add("Programming");
    }};

    public static final Set<String> ACTIVITIES_3 = new HashSet<>() {{
        add("Basketball");
        add("Meditation");
        add("Yoga");
    }};

    public static final Set<String> ACTIVITIES_4 = new HashSet<>() {{
        add("Walking");
        add("Meditation");
        add("Running");
    }};

    public static final User USER_1 = new User(1, "Ivan", 32, ACTIVITIES_2);
    public static final User USER_2 = new User(2, "Anna", 23, ACTIVITIES_4);
    public static final User USER_3 = new User(3, "Maria", 32, ACTIVITIES_1);
    public static final User USER_4 = new User(4, "Michael", 44, ACTIVITIES_3);
    public static final User USER_5 = new User(5, "Irina", 23, ACTIVITIES_2);

    public static final List<User> USERS = List.of(USER_1, USER_2, USER_3, USER_4, USER_5);

    public static final Map<User, String> CORRECT_USER_MAP = new HashMap<>() {{
        put(USER_1, "Yoga");
        put(USER_3, "Swimming");
        put(USER_4, "Yoga");
        put(USER_5, "Yoga");
    }};

    public static final Map<User, String> INCORRECT_USER_MAP = new HashMap<>() {{
        put(USER_3, "Programming");
        put(USER_1, "Dance");
        put(USER_2, "Meditation");
    }};
}
