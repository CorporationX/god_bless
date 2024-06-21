package faang.school.godbless.mightandmagic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter

public class Army {
    private List<Unit> subdivision;
    List<Unit> mages = new ArrayList<>();
    List<Unit> archers= new ArrayList<>();
    List<Unit> swordsmans = new ArrayList<>();

    List<PowerThread> mageThreads = new ArrayList<>();
    List<PowerThread> swordsmansThreads = new ArrayList<>();
    List<PowerThread> archerThreads = new ArrayList<>();


    public Army(List<Unit> subdivision) {
        this.subdivision = subdivision;
    }

    public int calculateTotalPower() throws InterruptedException {
        subdivision.forEach(el->{
            if(el.isMage()) {
                PowerThread powerThread = new PowerThread(el);
                mageThreads.add(powerThread);
                powerThread.start();
            }
            if(el.isArcher()) {
                PowerThread powerThread = new PowerThread(el);
                archerThreads.add(powerThread);
                powerThread.start();
            }
            if(el.isSwordsman()) {
                PowerThread powerThread = new PowerThread(el);
                swordsmansThreads.add(powerThread);
                powerThread.start();
            }
        });
        int totalMageGroupPower = calculateGroupPower(mageThreads);
        int totalSwordsmansGroupPower = calculateGroupPower(swordsmansThreads);
        int totalArcherGroupPower = calculateGroupPower(archerThreads);
        System.out.println("Mage = "+totalMageGroupPower);
        System.out.println("swordsmen = "+totalSwordsmansGroupPower);
        System.out.println("archers = "+totalArcherGroupPower);
        return totalMageGroupPower+totalSwordsmansGroupPower+totalArcherGroupPower;
    }
    private int calculateGroupPower(List<PowerThread> threads) throws InterruptedException {
        int totalGroupPower = 0;
        for (PowerThread thread : threads) {
            thread.join();
            totalGroupPower+= thread.getPower();
        }
        return totalGroupPower;
    }
}
