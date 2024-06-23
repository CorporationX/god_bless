package faang.school.godbless.task36;

public class King {
    public static void main(String[] args) {
        Knight knight1 = new Knight("Sir Lancelot");
        knight1.addTrial(new Trial("Sir Lancelot", "The Quest for the Holy Grail"));
        knight1.addTrial(new Trial("Sir Lancelot", "The Joust with Sir Galahad"));

        Knight knight2 = new Knight("Sir Galahad");
        knight2.addTrial(new Trial("Sir Galahad", "The Search for the Lost City"));
        knight2.addTrial(new Trial("Sir Galahad", "The Tourney of Camelot"));

        knight1.startTrials();
        knight2.startTrials();
    }
}
