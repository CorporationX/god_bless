package faang.school.godbless.multithreading.matters_of_the_heart;

import java.util.List;
import java.util.Random;

public record UserList(List<User> users) {
    public static User getRandomUserFromList(List<User> users) {
         int index = new Random().nextInt(users.size());
         return users.get(index);
    }

    public void add(User user) {
        users.add(user);
    }
}
