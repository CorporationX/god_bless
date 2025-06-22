package school.faang.HeroesOfMightAndMagic81139;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {

    private CopyOnWriteArrayList<Squad<?>> squadsList = new CopyOnWriteArrayList<>();

    public int calculateTotalPower() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        AtomicInteger sum = new AtomicInteger(0);
        for (Squad<?> squad : squadsList) {
            Thread thread = new Thread(squad::calculateSquadPower);
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.join();
        }
        for (Squad<?> squad : squadsList) {
            sum.addAndGet(squad.getAllPower());
        }
        return sum.get();
    }

    public void addSquad(Squad<?> squad) {
        squadsList.add(squad);
    }
}
