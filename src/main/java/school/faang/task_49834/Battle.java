package school.faang.task_49834;

import lombok.SneakyThrows;

public class Battle {
    @SneakyThrows
    public static void main(String[] args) {
        Boss boss = new Boss(2);
        Player firstPlayer = new Player("First Player");
        Player secondPlayer = new Player("Second Player");
        Player thirdPlayer = new Player("Third Player");

        Thread thread1 = new Thread(() -> {
            try {
                firstPlayer.startBattle(boss);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });


        Thread thread2 = new Thread(() -> {
            try {
                secondPlayer.startBattle(boss);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                thirdPlayer.startBattle(boss);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

