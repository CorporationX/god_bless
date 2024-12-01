package school.faang.artemon.programm;



import school.faang.artemon.model.User;

import java.util.List;

class Main {
    public static void main(String[] args) {
        System.out.println("test");

        List<User> list = List.of(new User("test1", 10),
                new User("test2", 11),
                new User("test3", 10));

        System.out.println(User.groupUsers(list).entrySet());
    }
}