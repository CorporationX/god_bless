package faang.school.godbless.tournament;

public class King {
    public static void main(String[] args) {
        Knight redKnight = new Knight("Red");
        Knight blueKnight = new Knight("Blue");
        redKnight.addTrial(new Trial("Red", "sword fighting"));
        blueKnight.addTrial(new Trial("Blue", "sword fighting"));
        redKnight.addTrial(new Trial("Red", "horse riding"));
        blueKnight.addTrial(new Trial("Blue", "horse riding"));

        redKnight.startTrials();
        blueKnight.startTrials();
    }
}
