package school.faang.task_49658;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);
        Player player1 = new Player("Гарри");
        Player player2 = new Player("Рон");
        Player player3 = new Player("Гермиона");
        Player player4 = new Player("Хагрит");
        Player player5 = new Player("Дамболдор");

        List<Thread> users = new ArrayList<>(5);
        users.add(new Thread(() -> {
            try {
                player1.startBattle(boss);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage() + "Ошибка сражения");
            }
        }));
        users.add(new Thread(() -> {
            try {
                player2.startBattle(boss);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage() + "Ошибка сражения");
            }
        }));
        users.add(new Thread(() -> {
            try {
                player3.startBattle(boss);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage() + "Ошибка сражения");
            }
        }));
        users.add(new Thread(() -> {
            try {
                player4.startBattle(boss);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage() + "Ошибка сражения");
            }
        }));
        users.add(new Thread(() -> {
            try {
                player5.startBattle(boss);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage() + "Ошибка сражения");
            }
        }));

        users.forEach(Thread::start);

    }
}
