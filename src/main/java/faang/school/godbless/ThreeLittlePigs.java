package faang.school.godbless;

import java.util.List;

public class ThreeLittlePigs {
    public static void main(String[] args) {
        PigThread nifnif = new Pig1Thread("Ниф-Ниф",0);
        PigThread nafnaf = new Pig2Thread("Нaф-Нaф", 1);
        PigThread noofnoof = new Pig3Thread("Нyф-Нyф", 2);

        List<PigThread> pigThreads = List.of(nifnif, nafnaf, noofnoof);

        for (PigThread pigThread : pigThreads){
            pigThread.start();
        }

        for(PigThread pigThread : pigThreads){
            try {
                pigThread.join();
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }

        System.out.println();
        System.out.println("######################################");
        System.out.println("###  Теперь можно их всех съесть!  ###");
        System.out.println("######################################");
    }
}
