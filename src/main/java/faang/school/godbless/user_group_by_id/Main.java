package faang.school.godbless.user_group_by_id;

import java.util.List;

public class Main {
    static List<User> users = List.of(new User("Charli", 25, "Policeman"),
            new User("Marty", 20, "Student"), new User("Henry", 20, "Sportsman"),
            new User("Maks", 45, "Builder"), new User("Sanny", 22, "Sailor"),
            new User("Hailey", 25, "Actress"));

    public static void main(String[] args) {
        User.groupUsers(users).entrySet().forEach(System.out::println);
    }
}
