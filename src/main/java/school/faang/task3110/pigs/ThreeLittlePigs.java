package school.faang.task3110.pigs;

public class ThreeLittlePigs {
    public static void main(String[] args) {
        Pig1Thread nifnif = new Pig1Thread("Nif-nif","солома");
        Pig2Thread nufnuf = new Pig2Thread("Nuf-nuf","палки");
        Pig3Thread nafnaf = new Pig3Thread("Naf-naf","кирпичи");

        PigThread[] array = new PigThread[]{nifnif,nufnuf,nafnaf};

        for(PigThread pigThread : array){
            pigThread.start();
        }

        for (PigThread pigThread : array){
            try {
                pigThread.join();
            } catch (InterruptedException e) {
                System.out.println("Ошибка, свиньи не успели достроить дома");
                throw new IllegalStateException(e.getMessage());
            }
        }
        System.out.println("Все свиньи достроили дома!");
    }
}
