package faang.school.godbless.sprint_3.multithreading_parallelism_thread.task_3_heroes;

import faang.school.godbless.sprint_3.multithreading_parallelism_thread.task_3_heroes.units.Unit;

public class UnitThread extends Thread{
    private final String nameThread;
    private final Unit unit;
    private int unitPower;

    public UnitThread(String nameThread, Unit unit) {
        this.nameThread = nameThread;
        this.unit = unit;
    }

    public int getUnitPower() {
        return unitPower;
    }

    @Override
    public void run() {
        System.out.println("Работает " + nameThread);
        unitPower = unit.getPower();
    }
}
