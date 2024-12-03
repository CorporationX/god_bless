package school.faang.task43965;

import school.faang.task43965.model.User;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        User user1 = new User("1-123", "Ivan", 34);
        user1.addActivities(Set.of("Tennis"));

        User user2 = new User("1-124", "Maria", 19);
        user2.addActivities(Set.of("Tennis", "Ping-Pong"));

        User user3 = new User("1-125", "Gleb", 58);
        user3.addActivities(Set.of("Tennis", "Ping-Pong", "Football"));

        User user4 = new User("1-126", "Marina", 39);
        user4.addActivities(Set.of("Tennis", "Ping-Pong", "Poker"));

        User user5 = new User("1-127", "Petr", 29);
        user5.addActivities(Set.of("Ping-Pong", "Poker", "Chess", "Nards"));

        List<User> users = new ArrayList<>();

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        Set<String> checkedActivities = Set.of("Ping-Pong", "Chess");

        HashMap<User, String> selectedUsers;
        selectedUsers = User.findHobbyLovers(users, checkedActivities);

        System.out.println(selectedUsers);
    }
}

