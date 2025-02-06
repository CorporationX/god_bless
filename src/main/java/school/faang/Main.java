package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        addMyUsers(users);
        Map<Integer,List<User>> groupedUsers = User.groupUsers(users);
        printMap(groupedUsers);
    }
    private static void printMap (Map<Integer,List<User>> map){
        for (Map.Entry<Integer, List<User>> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
    private static void addMyUsers (List<User> users){
        users.add(new User("Ivan", 28, "Google", "London"));
        users.add(new User("Maria", 15, "Apple", "New York"));
        users.add(new User("Alexey", 28, "Microsoft", "Amsterdam"));
        users.add(new User("Anna", 29, "Amazon", "Moscow"));
        users.add(new User("Sergey", 31, "Facebook", "New York"));
        users.add(new User("Olga", 30, "Samsung", "Amsterdam"));
        users.add(new User("Dmitry", 17, "IBM", "London"));
        users.add(new User("Ekaterina", 32, "Tesla", "New York"));
        users.add(new User("Anastasia", 29, "Oracle", "Amsterdam"));
        users.add(new User("Kirill", 30, "Adobe", "London"));
        users.add(new User("Yegor", 28, "Spotify", "New York"));
    }
}
