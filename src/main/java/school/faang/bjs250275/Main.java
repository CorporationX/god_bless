package school.faang.bjs250275;

import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws Exception {
        final long start = System.currentTimeMillis();
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);
        Robot bb8 = new Robot("BB-8", 6, 6);

        Future<Robot> battleOfr2d2Vsc3po = battle.fight(r2d2, c3po);
        Future<Robot> battleOfr2d2Vsbb8 = battle.fight(r2d2, bb8);
        Future<Robot> battleOfc3poVsbb8 = battle.fight(c3po, bb8);

        Robot winner1 = battleOfr2d2Vsc3po.get();
        System.out.println("Winner of battle between r2d2 and c3po is : " + winner1.getName());

        Robot winner2 = battleOfr2d2Vsbb8.get();
        System.out.println("Winner of battle between r2d2 and bb8 is : " + winner2.getName());

        Robot winner3 = battleOfc3poVsbb8.get();
        System.out.println("Winner of battle between c3po and bb8 is : " + winner3.getName());
        battle.shutdown();
        long end = System.currentTimeMillis();
        System.out.println("time elapsed: " + (end - start));
    }

}
