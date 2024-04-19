package faang.school.godbless.matters_of_the_heart;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UserList {
    @Getter
    private List<User> allUsers;
    private Queue<User> userList;

    public UserList(List<User> users) {
        this.userList = new LinkedList<>();
        this.allUsers = users;
    }

    // Решил переименовать метод(из getOnlineUsers), так как в данной задаче нам важны только пользователи,
    // которые хотят начать чат, на их онлайн статус нам все равно
    public Queue<User> getWaitForChatUsers() {
        return userList;
    }

    public void setWaitForChatStatusToUser(User user) {
        userList.add(user);
    }
}