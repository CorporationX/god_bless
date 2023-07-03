package tournament_among_kings;

public class King {
    public static void main(String[] args) {
        Knight firstKnight = new Knight("first knight");
        Knight secondKnight = new Knight("second knight");

        firstKnight.addTrial(new Trial(firstKnight.getName(), "overcome difficulties"));
        firstKnight.addTrial(new Trial(firstKnight.getName(), "stay strong"));

        secondKnight.addTrial(new Trial(secondKnight.getName(), "win fight"));
        secondKnight.addTrial(new Trial(secondKnight.getName(), "to be alive"));

        firstKnight.startTrials();
        secondKnight.startTrials();
    }
}
