package school.faang.m1s3.bjs2_36309_witcher;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        long startProgram = System.currentTimeMillis();

        List<City> knownCities = new ArrayList<>(List.of(
                new City("Vyzima"),
                new City("Novigrad"),
                new City("Velen"),
                new City("Toussaint"),
                new City("Oxenfurt")
        ));

        List<Monster> monsters = new ArrayList<>(List.of(
                new Monster("Ghoul"),
                new Monster("Kikimora"),
                new Monster("Basylisk"),
                new Monster("Stryga"),
                new Monster("Vampire")
        ));

        Witcher geralt = new Witcher("Geralt");
        geralt.questLocator(knownCities, monsters);

        System.out.println("Execution time 5 threads: " + (System.currentTimeMillis() - startProgram) + " ms");
    }
}
