package faang.school.godbless.tournament;

public class Main {
    public static void main(String[] args) {
        Knight knight1 = new Knight("Великий");
        Knight knight2 = new Knight("Всемогущий");
        knight1.addTrial(new Trial(knight1.getName(), "first step"));
        knight1.addTrial(new Trial(knight1.getName(), "second step"));
        knight2.addTrial(new Trial(knight2.getName(), "first step"));
        knight2.addTrial(new Trial(knight2.getName(), "second step"));

        knight1.startTrials();
        knight2.startTrials();
    }
}