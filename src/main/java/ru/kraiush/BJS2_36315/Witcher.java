package ru.kraiush.BJS2_36315;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final int THREAD_POOL_SIZE_MULTI = 5;
    private static final int THREAD_POOL_SIZE_MONO = 1;

    public static void main(String[] args) {
        City whiteOrchard = new City("White Orchard", new Location(52, 18));
        City vizima = new City("Vizima", new Location(34, 47));
        City novigrad = new City("Novigrad", new Location(25, 80));
        City oxenfurt = new City("Oxenfurt", new Location(77, 25));
        City skellige = new City("Skellige", new Location(49, 49));

        List<Monster> monsters = new ArrayList<>(Arrays.asList(
                new Monster("Griffin", new Location(25, 16)),
                new Monster("Basilisk", new Location(40, 40)),
                new Monster("Drowner", new Location(50, 40)),
                new Monster("Wraith", new Location(30, 35)),
                new Monster("Leshen", new Location(70, 60)),
                new Monster("Manticore", new Location(20, 20)),
                new Monster("Kikimora", new Location(60, 40)),
                new Monster("Vampire", new Location(59, 52))
        ));

        CityWorker cityWorker1 = new CityWorker(whiteOrchard, monsters);
        CityWorker cityWorker2 = new CityWorker(vizima, monsters);
        CityWorker cityWorker3 = new CityWorker(novigrad, monsters);
        CityWorker cityWorker4 = new CityWorker(oxenfurt, monsters);
        CityWorker cityWorker5 = new CityWorker(skellige, monsters);

        ExecutorService executorServiceMulti = Executors.newFixedThreadPool(THREAD_POOL_SIZE_MULTI);
        long startMulti = System.currentTimeMillis();
        executorServiceMulti.submit(cityWorker1);
        executorServiceMulti.submit(cityWorker2);
        executorServiceMulti.submit(cityWorker3);
        executorServiceMulti.submit(cityWorker4);
        executorServiceMulti.submit(cityWorker5);
        executorServiceMulti.shutdown();
        try {
            if (executorServiceMulti.awaitTermination(60, TimeUnit.SECONDS)) {
                executorServiceMulti.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endMulti = System.currentTimeMillis();
        System.out.println("Time of multithreading process: " + (endMulti - startMulti) + " milliseconds");

        ExecutorService executorServiceMono = Executors.newFixedThreadPool(THREAD_POOL_SIZE_MONO);
        long startMono = System.currentTimeMillis();
        executorServiceMono.submit(cityWorker1);
        executorServiceMono.submit(cityWorker2);
        executorServiceMono.submit(cityWorker3);
        executorServiceMono.submit(cityWorker4);
        executorServiceMono.submit(cityWorker5);
        executorServiceMono.shutdown();
        try {
            if (executorServiceMono.awaitTermination(60, TimeUnit.SECONDS)) {
                executorServiceMono.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endMono = System.currentTimeMillis();
        System.out.println("Time of monothreading process: " + (endMono - startMono) + " milliseconds");
    }
}
