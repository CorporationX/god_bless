package school.faangSprint3.t10;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> roles = List.of("King", "Hand of the King", "Master of Coin");
        House starkHouse = new House("Stark", roles);

        User[] users = new User[5];
        Thread[] threads = new Thread[5];

        for (int i = 0; i < users.length; i++) {
            users[i] = new User("User" + (i + 1));
            users[i].setHouse(starkHouse);
            threads[i] = new Thread(users[i]);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Все пользователи завершили работу");
    }
}