package faang.school.godbless.sprint_3.multithreading.super_cow;

public class Main {
    public static void main(String[] args) {
        Boss medusa = new Boss(5, 3);
        Player first = new Player("Alucard");
        Player second = new Player("Vanguard");
        Player third = new Player("Phoenix");
        Thread firstThread = new Thread(() -> first.startBattle(medusa));
        Thread secondThread = new Thread(() -> second.startBattle(medusa));
        Thread thirdThread = new Thread(() -> third.startBattle(medusa));
        firstThread.start();
        secondThread.start();
        thirdThread.start();
    }
}
