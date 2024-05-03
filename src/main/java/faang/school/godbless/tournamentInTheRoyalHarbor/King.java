package faang.school.godbless.tournamentInTheRoyalHarbor;

public class King {
    public static void main(String[] args) {
        Knight knight1 = new Knight("Arthur Dane");
        knight1.addTrial(new Trial(knight1.getName(), "Jousting"));
        knight1.addTrial(new Trial(knight1.getName(), "Swordsmanship"));

        Knight knight2 = new Knight("Barrister Selma");
        knight2.addTrial(new Trial(knight2.getName(), "Skill at arms"));
        knight2.addTrial(new Trial(knight2.getName(), "Archery"));

        knight1.startTrials();
        knight2.startTrials();
    }
}