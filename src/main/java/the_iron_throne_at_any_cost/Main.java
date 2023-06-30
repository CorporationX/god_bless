package the_iron_throne_at_any_cost;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        House houseOfLannister = new House("Lannisters", 5);
        House houseOfStark = new House("Starks", 4);

        ExecutorService executorService = Executors.newCachedThreadPool();

        User cersei = new User("Cersei");
        User tywin = new User("Tywin");
        User joffrey = new User("Joffrey");
        User tyrion = new User("Tyrion");
        User jaime = new User("Jaime");
        User arya = new User("Arya");
        User rob = new User("Rob");
        User ned = new User("Ned");
        User sansa = new User("Sansa");

        List<Runnable> actions = Arrays.asList(
                () -> cersei.joinHouse(houseOfLannister,"queen mother"),
                () -> tywin.joinHouse(houseOfLannister,"hand of the king"),
                () -> joffrey.joinHouse(houseOfLannister,"king"),
                () -> tyrion.joinHouse(houseOfLannister,"hand of the king"),
                () -> jaime.joinHouse(houseOfLannister,"knight of the royal guard"),
                () -> arya.joinHouse(houseOfStark,"lady of Winterfell"),
                () -> rob.joinHouse(houseOfStark,"king of the North"),
                () -> ned.joinHouse(houseOfStark,"lord of Winterfell"),
                () -> sansa.joinHouse(houseOfStark,"queen of the North"),
                cersei::leaveHouse,
                tywin::leaveHouse,
                joffrey::leaveHouse,
                jaime::leaveHouse,
                rob::leaveHouse,
                ned::leaveHouse
        );

        for (Runnable action: actions){
            executorService.submit(action);
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
