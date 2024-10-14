package school.BJS2_36353;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Pig1Thread Nif_Nif = new Pig1Thread("Ниф-Ниф","Солома");
        Pig2Thread Naf_Naf = new Pig2Thread("Наф-Наф","Кирпичи");
        Pig3Thread Nuf_Nuf = new Pig3Thread("Нуф-Нуф","Палки");

        Nif_Nif.start();
        Nuf_Nuf.start();
        Naf_Naf.start();

        Nif_Nif.join();
        Naf_Naf.join();
        Nuf_Nuf.join();
        System.out.println("Игра завершена");
    }
}