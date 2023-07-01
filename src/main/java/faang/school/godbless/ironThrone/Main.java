package faang.school.godbless.ironThrone;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        House house = new House();
        house.addRole("King");
        house.addRole("Knight");
        house.addRole("Master of Coin");


        Queue<String> userNames = new LinkedList<>();
        userNames.offer("John");
        userNames.offer("Tyrion");
        userNames.offer("Aegon");
        userNames.offer("Bran");
        userNames.offer("Jaime");

        List<String> houseNames = Arrays.asList("StarkHouse", "LannisterHouse", "TargaryenHouse");

        List<User> users = new ArrayList<>();

        for (int i = 1; !userNames.isEmpty(); i++) {
            String userName = userNames.poll();
            String houseName = houseNames.get((i - 1) % houseNames.size());
            if (userName == null) {
                break;
            }

            User user = new User(userName, house, houseName);
            users.add(user);
            Thread thread = new Thread(user::joinHouse);
            thread.start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.err.println("Thread was interrupted after leaving the house: " + e.getMessage());
        }

    }
}
