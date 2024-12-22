package school.faang.bjs49802;

public class Main {

    public static void main(String[] args) {
        TamagotchiVlad vladinka = new TamagotchiVlad("Vladinka");
        TamagotchiVlad vladushka = new TamagotchiVlad("Vladushka");
        VladController parvin = new VladController();
        parvin.addVlad(vladinka);
        parvin.addVlad(vladushka);
        Thread t1 = new Thread(parvin::feedAll);
        t1.start();
        Thread t2 = new Thread(parvin::playAll);
        t2.start();
        Thread t3 = new Thread(parvin::cleanAll);
        t3.start();
        Thread t4 = new Thread(parvin::sleepAll);
        t4.start();
    }

}
