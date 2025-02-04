package school.faang;

import school.faang.group_users_by_age.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<User> users = List.of(
                new User("Pitr", 23, "Gazprom", "Mos"),
                new User("Lama", 23, "Lucoil", "Minsk"),
                new User("Kisha", 22, "Lucoil", "Pirm"),
                new User("Kuzi", 33, "Magnit", "Minsk"));

        System.out.print(User.groupUsers(users));
    }
}

