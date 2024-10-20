package school.faang.Multithreading.sprint_3.IronThrone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        List<String> roles = new ArrayList<>(Arrays.asList("Лорд", "Рыцарь", "Маг", "Лекарь"));

        House stark = new House("Stark", roles);

        User lord = new User("Лорд Stark");
        User mage = new User("Маг Vermeshel");
        User doctor = new User("Лекарь Lapsha");
        User knight = new User("Рыцарь Snow");
        User wifeLord = new User("Жена Лорда");
        User doterLord = new User("Дочь Лорда");

        lord.joinHouse(stark, "Лорд");

        ExecutorService executor = Executors.newFixedThreadPool(5);
//        executor.execute(() ->  lord.joinHouse(stark, "Лорд"));
        executor.execute(() ->  mage.joinHouse(stark, "Маг"));
        executor.execute(() -> doctor.joinHouse(stark, "Лекарь" ));
        executor.execute(() ->  knight.joinHouse(stark, "Рыцарь"));
        executor.execute(() -> wifeLord.joinHouse(stark, "Лорд"));
        executor.execute(() -> lord.leaveHouse(stark));
        executor.execute(() ->  doterLord.joinHouse(stark,"Лорд"));

        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
            doterLord.joinHouse(stark, "Лорд");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println();


//        doterLord.joinHouse(stark,"Лорд");
//        lord.leaveHouse(stark);
//        doterLord.joinHouse(stark , "Лорд");

    }
}
