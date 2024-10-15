package school.BJS2_36353;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Pig1Thread nif_Nif = new Pig1Thread("Ниф-Ниф","Солома");
        Pig2Thread naf_Naf = new Pig2Thread("Наф-Наф","Кирпичи");
        Pig3Thread nuf_Nuf = new Pig3Thread("Нуф-Нуф","Палки");

        nif_Nif.start();
        nuf_Nuf.start();
        naf_Naf.start();

        nif_Nif.join();
        naf_Naf.join();
        nuf_Nuf.join();
        System.out.println("Игра завершена");
    }
}