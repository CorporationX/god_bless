package faang.school.godbless.tamagotchi_vlad;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int THREAD_NUM = 2;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUM);

        List<TamagotchiVlad> tamagotchiVladList = getTamagotchiVladList();
        VladController vladControllerFirst = getVladController("FirstOwner", tamagotchiVladList);
        VladController vladControllerSecond = getVladController("SecondOwner", tamagotchiVladList);


        executorService.execute(() -> {
            vladControllerFirst.cleanAll();
            vladControllerFirst.feedAll();

            vladControllerFirst.removeTamagtochiToList(0);

            vladControllerFirst.sleepAll();
            vladControllerFirst.playAll();
        });

        executorService.execute(() -> {
            vladControllerSecond.sleepAll();
            vladControllerSecond.playAll();

            vladControllerFirst.removeTamagtochiToList(0);

            vladControllerSecond.feedAll();
            vladControllerSecond.cleanAll();
        });

        executorService.shutdown();
    }

    private static List<TamagotchiVlad> getTamagotchiVladList() {
        List<TamagotchiVlad> tamagotchiVladList = new ArrayList<>();

        tamagotchiVladList.add(new TamagotchiVlad("First"));
        tamagotchiVladList.add(new TamagotchiVlad("Second"));
        tamagotchiVladList.add(new TamagotchiVlad("Third"));
        tamagotchiVladList.add(new TamagotchiVlad("Fourth"));
        tamagotchiVladList.add(new TamagotchiVlad("Fifth"));
        tamagotchiVladList.add(new TamagotchiVlad("Sixth"));

        return tamagotchiVladList;
    }

    private static VladController getVladController(String ownerName, List<TamagotchiVlad> tamagotchiVladList) {
        return new VladController(ownerName, tamagotchiVladList);
    }
}
