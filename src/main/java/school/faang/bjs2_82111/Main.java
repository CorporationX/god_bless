package school.faang.bjs2_82111;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(0, "Бык", 2);
        Player superCow = new Player(0, "Супер Корова");
        Player hero = new Player(1, "Hero");
        Player cat = new Player(2, "Cat");

        Thread threadSuperCow = new Thread(() -> superCow.doBattle(boss));
        Thread threadHero = new Thread(() -> hero.doBattle(boss));
        Thread threadCat = new Thread(() -> cat.doBattle(boss));

        threadSuperCow.start();
        threadCat.start();
        threadHero.start();
    }


}
