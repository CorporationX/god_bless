package school.faang;

import school.faang.task_44016.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static school.faang.task_44016.User.groupUsers;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        User alisa = new User("Alisa", 12, " - ", "USA");
        User maria = new User("Maria", 15, " - ", "USA");
        User alex = new User("Alex", 12, " - ", "USA");
        User tom = new User("Tom", 15, " - ", "USA");
        User dima = new User("Dima", 15, " - ", "USA");

        users.add(alisa);
        users.add(maria);
        users.add(alex);
        users.add(tom);
        users.add(dima);

        Map<Integer, List<User>> sameAge = groupUsers(users);
        System.out.println(sameAge);
    }
}
