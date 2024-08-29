package ru.kraiush.threads.BJS2_23511;

import java.util.*;
import java.util.concurrent.*;

public class AppDistributedArmyOfHeroesOfMightAndMagic {

    public static void main(String[] args) {

        Character archer= new Archer("Azalea", "elf", 19);
        Character cleric= new Cleric("Vyrana", "numan", 15);
        Character knight= new Knight("Kraiu", "human", 17);
        Character mage=  new Mage("Flora", "elf", 11);
        Character robber = new Robber("Jhared", "dwarf", 27);
        Character wizard = new Wizard("Lilac", "elf", 10);

        List<Character> listHeroes= new ArrayList<>();
        listHeroes.add(archer);
        listHeroes.add(cleric);
        listHeroes.add(knight);
        listHeroes.add(mage);
        listHeroes.add(robber);
        listHeroes.add(wizard);
        System.out.print(String.join("", Collections.nCopies(80, "-")));
        System.out.println("\nlistHeroes: " + listHeroes);

        ExecutorService executorService= Executors.newFixedThreadPool(3);

        calculateTotalPower(executorService, listHeroes);

        System.out.print(String.join("", Collections.nCopies(80, "-")));
    }
    private static void calculateTotalPower(ExecutorService pool, List<Character> listHeroes) {

        Set<Future<Integer>> set = new HashSet<>();

        for (Character itemFuture : listHeroes) {
            Callable<Integer> callable =new Army(itemFuture);
            Future<Integer> future = pool.submit(callable);
            set.add(future);
        }
        int sum = 0;
        try {
            for (Future<Integer> future : set) {
                sum += future.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.printf("\nThe sum of hoeroes power is %s%n", sum);
        pool.shutdown();
    }
}
