package faang.school.godbless.Iron_Throne;

import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        House ironThrone = new House(new HashSet<>(), 0, new HashMap<>());
        ironThrone.addRole("King");
        ironThrone.addRole("Queen");
        ironThrone.addRole("Hand of the King");
        User jonSnow = new User("Jon Snow", null, null);
        User daenerysTargaryen = new User("Daenerys Targaryen", null, null);
        User tyrionLannister = new User("Tyrion Lannister", null, null);
        Thread thread1 = new Thread(() -> jonSnow.joinHouse(ironThrone));
        Thread thread2 = new Thread(() -> daenerysTargaryen.joinHouse(ironThrone));
        Thread thread3 = new Thread(() -> tyrionLannister.joinHouse(ironThrone));
        thread1.start();
        thread2.start();
        thread3.start();
        Thread thread4 = new Thread(() -> jonSnow.leaveHouse());
        Thread thread5 = new Thread(() -> ironThrone.addRole("Knight of the Krone"));
        Thread thread6 = new Thread(() -> ironThrone.removeRole("Hand of the King"));
        thread4.start();
        thread5.start();
        thread6.start();
    }
}
