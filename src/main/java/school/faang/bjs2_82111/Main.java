package school.faang.bjs2_82111;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Boss boss = new Boss("Бык", 2);
        Player superCow = new Player(0, "Супер Корова");

        superCow.doBattle(boss);
    }


}
