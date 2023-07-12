package faang.school.godbless.multithreading.tamagochi;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        VladController controller = new VladController();

        List<TamagochiVlad> tamagochiVladList = List.of(
                new TamagochiVlad("Vlad-1"),
                new TamagochiVlad("Vlad-2"),
                new TamagochiVlad("Vlad-3")
        );

        Thread thread1 = new Thread(() -> {
            tamagochiVladList.forEach(controller::addTamagochiVlad);
            controller.feedALL();
            controller.getTamagochiVladList().forEach(TamagochiVlad::getCondition);
            controller.playALL();
            controller.getTamagochiVladList().forEach(TamagochiVlad::getCondition);
            controller.cleanALL();
            controller.getTamagochiVladList().forEach(TamagochiVlad::getCondition);
            controller.sleepALL();
            controller.getTamagochiVladList().forEach(TamagochiVlad::getCondition);
        }, "Thread-1");

        Thread thread2 = new Thread(() -> {
            controller.playALL();
            controller.getTamagochiVladList().forEach(TamagochiVlad::getCondition);
            controller.sleepALL();
            controller.getTamagochiVladList().forEach(TamagochiVlad::getCondition);
            controller.removeTamagochiVlad(tamagochiVladList.get(0));
            controller.playALL();
            controller.getTamagochiVladList().forEach(TamagochiVlad::getCondition);
            controller.cleanALL();
            controller.getTamagochiVladList().forEach(TamagochiVlad::getCondition);
        }, "Thread-2");

        thread1.start();
        thread2.start();
    }
}
