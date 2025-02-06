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
        users.add(new User("Ivan", 28, "Google", "Tokyo"));
        users.add(new User("Maria", 29, "Apple", "Sydney"));
        users.add(new User("Alexey", 28, "Microsoft", "Rio de Janeiro"));
        users.add(new User("Anna", 29, "Amazon", "Cairo"));
        users.add(new User("Sergey", 31, "Facebook", "Cape Town"));
        users.add(new User("Olga", 30, "Samsung", "Buenos Aires"));
        users.add(new User("Dmitry", 28, "IBM", "Berlin"));
        users.add(new User("Ekaterina", 32, "Tesla", "Seoul"));
        users.add(new User("Anastasia", 29, "Oracle", "Mumbai"));
        users.add(new User("Kirill", 30, "Adobe", "Mexico City"));
        users.add(new User("Yegor", 28, "Spotify", "Istanbul"));
        users.add(new User("Elena", 25, "Nokia", "Lisbon"));
        users.add(new User("Maxim", 35, "Oracle", "Zurich"));
        users.add(new User("Svetlana", 35, "Intel", "Hanoi"));
        users.add(new User("Andrei", 22, "Snapchat", "Bangkok"));
        users.add(new User("Natalia", 27, "Stripe", "Nairobi"));
        users.add(new User("Vladimir", 33, "Salesforce", "Kuala Lumpur"));
        users.add(new User("Daria", 26, "PayPal", "Oslo"));
        users.add(new User("Filipp", 31, "LinkedIn", "Athens"));
        users.add(new User("Victoria", 24, "Ubuntu", "Prague"));
        users.add(new User("Nikita", 29, "Zoom", "Lima"));

    }
}
