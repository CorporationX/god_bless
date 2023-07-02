package faang.school.godbless.multithreading.tamagotchi_Vlad;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VladController {
    List<TamagotchiVlad> vlads;

    ExecutorService service;

    public VladController(List<TamagotchiVlad> vlads) {
        this.vlads = vlads;
        service = Executors.newCachedThreadPool();
    }

    public void addVlad(TamagotchiVlad vlad) {
        vlads.add(vlad);
        System.out.println(vlad.getName() + " added");
    }

    public void removeVlad(TamagotchiVlad vlad) {
        synchronized (vlad) {
            if (vlad.isWorking()) {
                System.out.println(vlad.getName() + " is in work, it cannot be deleted. Wait..");
                try {
                    vlad.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            vlads.remove(vlad);
            System.out.println(vlad.getName() + " removed");
        }
    }

    public void feedAll() {
        vlads.forEach(vlad -> service.execute(vlad::feed));
    }

    public void playAll() {
        vlads.forEach(vlad -> service.execute(vlad::play));
    }

    public void cleanAll() {
        vlads.forEach(vlad -> service.execute(vlad::clean));
    }

    public void sleepAll() {
        vlads.forEach(vlad -> service.execute(vlad::sleep));
    }
}
