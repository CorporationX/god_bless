package faang.school.godbless.tournamentKing;

public class King {
    public static void main(String[] args) {
        Knight knight1 = new Knight("Ser Jorah");
        knight1.addTrial(new Trial(knight1.getName(), "Trial 1"));
        knight1.addTrial(new Trial(knight1.getName(), "Trial 2"));

        Knight knight2 = new Knight("Ser Brienne");
        knight2.addTrial(new Trial(knight2.getName(), "Trial 1"));
        knight2.addTrial(new Trial(knight2.getName(), "Trial 2"));

        knight1.startTrials();
        knight2.startTrials();
    }
}
