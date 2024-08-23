package faang.school.godbless;

import faang.school.godbless.solger.Solger;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Army {
    List<Solger> list = new ArrayList<>();
    List<Thread> treadList = new ArrayList<>();
    public int calculateTotalPower(){
    AtomicInteger atomicInteger = new AtomicInteger(0);
        list.forEach(a->{
            Thread thread = new Thread(()->{
                atomicInteger.addAndGet(a.getPower());
            });
            treadList.add(thread);
            thread.start();
        });
        treadList.forEach(a ->{
            try {
                a.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        return atomicInteger.get();
    }

    public void addUnit(Solger swordsman) {
        list.add(swordsman);
    }
}
