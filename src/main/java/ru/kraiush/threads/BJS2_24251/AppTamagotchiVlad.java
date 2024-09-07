package ru.kraiush.threads.BJS2_24251;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppTamagotchiVlad {

    public static void main(String[] args) {

        String[] memberNames = {"Sharon", "Lewis"};
//        String[] memberNames = {"Sharon", "Maggie", "Lewis", "Steve", "John"};

        VladController controller= new VladController();

        List<TamagotchiVlad> listTamagotchies = new ArrayList<>();

        for (int i = 0; i < memberNames.length; i++) {
            listTamagotchies.add(new TamagotchiVlad(memberNames[i]));
        }
        System.out.print(String.join("", Collections.nCopies(80, "-")));
        System.out.println("\nFeeding the toy");
        listTamagotchies= controller.feedAll(listTamagotchies);

        System.out.println("\nLet's play with a toy");
        controller.playAll(listTamagotchies);

        System.out.println("\nAll the supplies are gone");
        controller.cleanAll(listTamagotchies);

        listTamagotchies.forEach(System.out::println);

        System.out.println("\nIt's time for everyone to sleep");
        controller.sleepAll(listTamagotchies);
        System.out.print(String.join("", Collections.nCopies(80, "-")));
    }
}
