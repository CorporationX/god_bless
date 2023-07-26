package faang.school.godbless.matters_of_heart;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class UserList {
    private List<User> userList;

    public List<User> getOnlineUsers(){
        return userList.stream().filter(user -> user.isOnline()).toList();
    }
}
