package group.user.by.age;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        List<User> listWithUsers = new ArrayList<>();
        listWithUsers.add(new User("Dan", 25, "Stefan cel Mare Street", "Chisinau MDA"));
        listWithUsers.add(new User("John", 45, "Wall Street", "New York NY"));
        listWithUsers.add(new User("Jane", 25, "Liberty Street", "Los Angeles CA"));
        listWithUsers.add(new User("Mike", 45, "Umbrela Street", "London UK"));

        for (Map.Entry<Integer, List<User>> listWithUsersEntry : User.groupUsers(listWithUsers).entrySet()) {
            Integer age = listWithUsersEntry.getKey();
            for (User user : listWithUsersEntry.getValue()) {
                System.out.println("User with age " + age + " is " + user.getName()
                        + " with working adress " + user.getWorkPlace()
                        + " based in " + user.getAdress());
            }
        }
    }
}
