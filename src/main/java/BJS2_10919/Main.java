package BJS2_10919;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Knight knight1 = new Knight("Lancelot");
        Knight knight2 = new Knight("Arthur");

        knight1.addTrial(new Trial(knight1.getName(), "Trial of Strength"));
        knight1.addTrial(new Trial(knight1.getName(), "Trial of Wisdom"));

        knight2.addTrial(new Trial(knight2.getName(), "Trial of Courage"));
        knight2.addTrial(new Trial(knight2.getName(), "Trial of Endurance"));

        System.out.println("Trials were started for:  " + knight1.getName() + ":");
        knight1.startTrial();

        System.out.println("Trials were started for: " + knight2.getName() + ":");
        knight2.startTrial();
    }
}
