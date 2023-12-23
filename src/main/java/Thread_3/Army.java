package Thread_3;

import Thread_3.Units.Unit;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Unit> listUnits = new ArrayList<>();
    private List<HMMThread> listThread = new ArrayList<>();

    public int calculateTotalPower() {
        int sumPower = 0;
        for (int i = 0; i < listUnits.size(); i++) {
            HMMThread thread = new HMMThread(listUnits.get(i));
            thread.start();
            listThread.add(thread);
        }
        for (HMMThread thread : listThread) {
            try {
                thread.join();
                System.out.println("Thread " + thread.getId() + " well done");
            } catch (InterruptedException e) {
                System.out.println("Thread " + thread.getId() + " was doing with Error");
            }
            sumPower += thread.getSumPower();
        }
        return sumPower;
    }

    public void removeUnit(Unit unit) {
        if (listUnits.contains(unit))
            listUnits.remove(unit);
        else
            System.out.println("Army don't include this unit");
    }

    public void addUnit(Unit unit) {
        listUnits.add(unit);
    }

    public List<Unit> getListUnits() {
        return listUnits;
    }
}
