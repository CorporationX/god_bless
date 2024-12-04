package school.faang.bjs243850.programm;

import school.faang.bjs243850.model.User;

import java.util.List;

class Main {
    public static void main(String[] args) {
        List<User> list = List.of(new User("test1", "home", "london", 10),
                new User("test2", "office", "moskow", 11),
                new User("test3", "home", "moldova", 10));

        System.out.println(User.groupUsers(list).entrySet());
    }
}