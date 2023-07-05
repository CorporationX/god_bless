package faang.school.godbless.tamagochy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        VladController vladController = new VladController();
        vladController.addTamagochi(new TamagochiVlad(0));
        vladController.addTamagochi(new TamagochiVlad(1));
        vladController.addTamagochi(new TamagochiVlad(2));
        vladController.addTamagochi(new TamagochiVlad(3));

        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 4; i++) {
            service.submit(vladController);
        }
        for (int i = 0; i < 4; i++) {
            vladController.addTamagochi(new TamagochiVlad(vladController.getVladList().size()+i));
            System.out.println("Тамагочи-Влад №" + (vladController.getVladList().size()+i) + " добавлен");
            vladController.removeTamagochi(i);
            System.out.println("Тамагочи-Влад №" + i + " удалён");
        }
        service.shutdown();
    }
}
