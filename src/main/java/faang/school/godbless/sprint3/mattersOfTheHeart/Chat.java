package faang.school.godbless.sprint3.mattersOfTheHeart;

import java.util.ArrayList;
import java.util.List;

public class Chat {

    private final List<User> users;

    public Chat() {
        users = new ArrayList<>();
    }

    public Chat(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void updateUsersBeforeDeletingChat() {
        users.forEach(user -> {
            user.setHaveActiveChat(false);
        });
    }

    @Override
    public String toString() {
        return "Chat{" +
                "users=" + users +
                '}';
    }

    //    private User firstUser;
//    private User secondUser;
//
//    public Chat(User firstUser, User secondUser) {
//        this.firstUser = firstUser;
//        this.secondUser = secondUser;
//    }
}
