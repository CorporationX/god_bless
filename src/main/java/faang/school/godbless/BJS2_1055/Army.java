package faang.school.godbless.BJS2_1055;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Unit> unitList;
    private List<PowerThread> archersList = new ArrayList<>();
    private List<PowerThread> swordsmenList = new ArrayList<>();
    private List<PowerThread> magesList = new ArrayList<>();
    public Army(List<Unit> unitList){
        this.unitList = unitList;
    }

    public int calculateTotalPower() throws InterruptedException {
        for (Unit unit : unitList) {
            if(unit.isArcher()){
                PowerThread powerThread = new PowerThread(unit);
                archersList.add(powerThread);
                powerThread.start();
            } else if (unit.isSwordsman()) {
                PowerThread powerThread = new PowerThread(unit);
                swordsmenList.add(powerThread);
                powerThread.start();
            } else if (unit.isMage()) {
                PowerThread powerThread = new PowerThread(unit);
                magesList.add(powerThread);
                powerThread.start();
            }
        }
        int totalArcherPower = getPowerSum(archersList);
        int totalSwordsmanPower = getPowerSum(swordsmenList);
        int totalMagePower = getPowerSum(magesList);

        System.out.println("Total Archer's power: "+totalArcherPower);
        System.out.println("Total Swordsman's power: "+totalSwordsmanPower);
        System.out.println("Total Mage's power: "+totalMagePower);

        return totalMagePower+totalArcherPower+totalSwordsmanPower;
    }

    public int getPowerSum(List<PowerThread> unitList) throws InterruptedException {
        int totalPower = 0;
        for (PowerThread powerThread : unitList) {
            powerThread.join();
            totalPower += powerThread.getPower();
        }
        return totalPower;
    }
}
