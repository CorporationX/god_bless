package school.faang.pigs;

public class ThreeLittlePigs {
    public static void main(String[] args) throws InterruptedException {
        Pig1Thread pig1Thread = new Pig1Thread("Nif-Nif", "соломы");
        Pig1Thread pig2Thread = new Pig1Thread("Nyf-Nyf", "досок");
        Pig1Thread pig3Thread = new Pig1Thread("Naf-Naf", "кирпича");

        pig1Thread.start();
        Thread.sleep(600);
        pig2Thread.start();
        Thread.sleep(700);
        pig3Thread.start();

        try {
            pig1Thread.join();
            pig2Thread.join();
            pig3Thread.join();
            System.out.println("Игра завершена");
        }  catch (InterruptedException e) {
            throw new IllegalStateException("Поток был прерван", e);
        }
    }
}
