package faang.school.godbless.mattersoftheheart;

import java.util.ArrayList;
import java.util.List;

public class UserList {

    private List<User> users = new ArrayList<>();

    {
        users.add(new User("Bob"));
        users.add(new User("Charlie"));
        users.add(new User("David"));
        users.add(new User("Emily"));
        users.add(new User("Frank"));
        users.add(new User("Grace"));
        users.add(new User("Henry"));
        users.add(new User("Ivy"));
        users.add(new User("Jack"));
        users.add(new User("Alice"));

    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getOnlineUsers(User user){
        return users.stream()
                .filter((other) -> other.isOnline() & !other.equals((user))) //only online users with excluded user
                .toList();
        //return a list of users that are online right now
    }







}
