package ru.kraiush.threads.BJS2_24251;

import java.util.ArrayList;
import java.util.List;

public class AppTamagotchiVlad {

    public static void main(String[] args) {

        String[] memberNames = {"Sharon", "Lewis", "Maggie"};

        List<TamagotchiVlad> listTamagotchies = new ArrayList<>();

        for (int i = 0; i < memberNames.length; i++) {
            listTamagotchies.add(new TamagotchiVlad(memberNames[i]));
        }

        Thread thread1 = new VladController(listTamagotchies, "CONTROLLER-1");
        Thread thread2 = new VladController(listTamagotchies, "CONTROLLER-2");
        thread1.start();
        thread2.start();
    }
}
