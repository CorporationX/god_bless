package faang.school.godbless.sprint3.tournament;

public class King {
    public static void main(String[] args) throws InterruptedException {
        Knight knight1 = new Knight("Pavel");
        Knight knight2 = new Knight("Anton");

        knight1.addTrial(new Trial(knight1.getName(), "Trial 1"));
        knight1.addTrial(new Trial(knight1.getName(), "Trial 2"));

        knight2.addTrial(new Trial(knight2.getName(), "Trial 1"));
        knight2.addTrial(new Trial(knight2.getName(), "Trial 2"));

        knight1.startTrials();
        knight2.startTrials();

    }
}
