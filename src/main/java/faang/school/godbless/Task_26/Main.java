package faang.school.godbless.Task_26;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        Archer archerOne = new Archer(10, 0, "John");
        Archer archerTwo = new Archer(10, 0, "Mike");

        Swordsman swordsmanOne = new Swordsman(10, 0, "Kelly");
        Swordsman swordsmanTwo = new Swordsman(10, 0, "Brian");


        Runnable runnable1 = () -> archerOne.strike(archerTwo, game);
        Runnable runnable2 = () -> archerTwo.strike(archerOne, game);

        Runnable runnable3 = () -> swordsmanOne.hit(swordsmanTwo, game);
        Runnable runnable4 = () -> swordsmanTwo.hit(swordsmanOne, game);

        for (int i = 0; i < 20; i++) {
            new Thread(runnable1).start();
            new Thread(runnable2).start();
            new Thread(runnable3).start();
            new Thread(runnable4).start();
        }
    }
}
