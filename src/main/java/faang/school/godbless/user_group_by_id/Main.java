package faang.school.godbless.user_group_by_id;

import java.util.List;

public class Main {
    static List<User> users = List.of(new User("Charli", 25, "Policeman","Chikago"),
            new User("Marty", 20, "Student", "Warsaw"),
            new User("Henry", 20, "Sportsman", "Moscow"),
            new User("Maks", 45, "Builder","Washington"),
            new User("Sanny", 22, "Sailor","Berlin"),
            new User("Hailey", 25, "Actress","Parish"));

    public static void main(String[] args) {
        User.groupUsers(users).entrySet().forEach(System.out::println);
    }
}
