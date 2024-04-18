package faang.school.godbless.MattersOfTheHeart;

import lombok.Data;

import java.util.ArrayList;

@Data
public class User {
    private final UserList likedUsers = new UserList(new ArrayList<>());
    private final UserList mutualUsers = new UserList(new ArrayList<>());
    private int id;
    private String name;
    private boolean isOnline;

    public User(int id, String name, boolean isOnline) {
        this.id = id;
        this.name = name;
        this.isOnline = isOnline;
    }

    public void like(User user) {
        if (user.equals(this)) {
            return;
        }
        likedUsers.addUser(user);
        user.getMutualUsers().addUser(this);
        System.out.printf("%s liked %s\n", name, user.getName());
    }

    public void dislike(User user) {
        if (user.equals(this)) {
            return;
        }
        likedUsers.removeUser(user);
        user.getMutualUsers().removeUser(this);
        System.out.printf("%s disliked %s\n", name, user.getName());
    }
}
