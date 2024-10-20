package ru.kraiush.BJS2_37102;

public class Main {
    public static void main(String[] args) {
        House house = new House();

        User user1 = new User("Lanister");
        User user2 = new User("Baratheon");
        User user3 = new User("Snow");
        User user4 = new User("Daineris");
        User user5 = new User("Aria");

        Thread thread1 = new Thread(() -> {
            user1.joinHouse(house);
        });

        Thread thread2 = new Thread(() -> {
            user2.joinHouse(house);
        });

        Thread thread3 = new Thread(() -> {
            user3.joinHouse(house);
            user3.leaveHouse();
        });

        Thread thread4 = new Thread(() -> {
            user4.joinHouse(house);
            user4.leaveHouse();
        });

        Thread thread5 = new Thread(() -> {
            user5.joinHouse(house);
            user5.leaveHouse();
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();


    }

}
