package faang.school.godbless.mattersOfTheheart;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserList {
    private final List<User> users = new ArrayList<>();

    public List<User> getOnlineUser() {
        return users.stream()
                .filter(User::isOnline)
                .collect(Collectors.toList());
    }

    public void addUser(User user){
        if(!users.contains(user)){
            users.add(user);
        }else{
            System.out.println("User already exist.");
        }
    }
}
