package faang.school.godbless.tamagotchi_vlad;

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
            vladControllerFirst.sleepAll();
            vladControllerFirst.playAll();
        });

        executorService.execute(() -> {
            vladControllerSecond.sleepAll();
            vladControllerSecond.playAll();
            vladControllerSecond.feedAll();
            vladControllerSecond.cleanAll();
        });

        executorService.shutdown();
    }

    private static List<TamagotchiVlad> getTamagotchiVladList() {
        return List.of(
                new TamagotchiVlad("First"), new TamagotchiVlad("Second")
//                , new TamagotchiVlad("Third"),
//                new TamagotchiVlad("Fourth"), new TamagotchiVlad("Fifth"), new TamagotchiVlad("Sixth")
        );
    }

    private static VladController getVladController(String ownerName, List<TamagotchiVlad> tamagotchiVladList) {
        return new VladController(ownerName, tamagotchiVladList);
    }
}
