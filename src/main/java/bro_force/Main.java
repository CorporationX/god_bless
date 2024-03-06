package bro_force;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Person sam = new Person("Sam", 5, false);
        Person artem = new Person("Artem", 7, false);
        Person max = new Person("Max", 3, false);
        Person vlad = new Person("Vlad", 5, false);
        Person ivan = new Person("Ivan", 9, false);

        game.addPerson(sam);
        game.addPerson(artem);
        game.addPerson(max);
        game.addPerson(vlad);
        game.addPerson(ivan);

        System.out.println(game.checkLose());
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < game.getPersonList().size(); i++) {
            executorService.submit(() -> {
                while (!game.checkLose()) {
                    boolean gaming = game.update();
                    System.out.println("Somebody dead? : " + gaming);
                }
            });
        }
        executorService.shutdown();
    }
}
