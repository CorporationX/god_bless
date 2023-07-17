package faang.school.godbless.multithreading.matters_heart;

import java.util.List;

public class UserList {
    private List<User> users;

    public UserList(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        if (users.contains(user)) {
            System.out.println(user.getName() + " already on the list");
            return;
        }
        users.add(user);
    }

    public void removeUser(User user) {
        if (users.contains(user)) {
            users.remove(user);
        } else {
            System.out.println(user.getName() + " not on the list");
        }
    }

    public List<User> getOnlineUsers() {
        return users.stream().filter(User::isOnline).toList();
    }
}
