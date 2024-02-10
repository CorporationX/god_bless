package faang.school.godbless.age_grouping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Alice", 25, "Company A", "Address 1"));
        users.add(new User("Bob", 30, "Company B", "Address 2"));
        users.add(new User("Charlie", 25, "Company C", "Address 3"));
        users.add(new User("David", 30, "Company D", "Address 4"));
        users.add(new User("Mark", 22, "Company D", "Address 4"));
        users.add(new User("Tom", 22, "Company D", "Address 4"));
        users.add(new User("Jack", 18, "Company D", "Address 4"));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);
        for(int age: groupedUsers.keySet()){
            List<User> userList = groupedUsers.get(age);
            System.out.println("Age: " + age);
           for(User user: userList){
               System.out.println( user.toString());
           }
        }
    }
    }


