package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static faang.school.godbless.User.groupUsers;


public class Application {
    public static void main(String[] args) {
    List<User> UserList = new ArrayList<>();
    UserList.add(new User("Ivan",18, "Google","St.Gogolya 38"));
    UserList.add(new User("Dima",20, "Amazon","St.Gogolya 39"));
    UserList.add(new User("Oleg",18, "Sber","St.Gogolya 36"));
    UserList.add(new User("Sasha",21, "Netflix","St.Gogolya 35"));
    UserList.add(new User("Nina",21, "Facebook","St.Gogolya 34"));
    UserList.add(new User("Senya",20, "VK","St.Gogolya 33"));

    Map<Integer , List<User>> groupedUsers = groupUsers(UserList);
    for(Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()){
        System.out.println("User with age: " + entry.getKey());
        for(User users : entry.getValue()){
            users.getRecord();
        }
    }
    }
}