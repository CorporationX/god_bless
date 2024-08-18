package faang.school.multithreadingparallelismthread.distributedarmyofheroes;

import faang.school.multithreadingparallelismthread.distributedarmyofheroes.entityes.Archer;
import faang.school.multithreadingparallelismthread.distributedarmyofheroes.entityes.Mage;
import faang.school.multithreadingparallelismthread.distributedarmyofheroes.entityes.Swordsman;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Army army = new Army();

        army.addArmy(new Archer(8));
        army.addArmy(new Mage(55));
        army.addArmy(new Swordsman(12));
        army.addArmy(new Swordsman(300));

        System.out.println(army.calculateTotalPower());
    }
}
