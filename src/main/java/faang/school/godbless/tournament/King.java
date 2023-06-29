package faang.school.godbless.tournament;

public class King {
    public static void main(String[] args) {
        Knight firstKnight = new Knight("Nikita");
        Knight secondKnight = new Knight("Fedor");

        addTrialsForKnight(
                firstKnight, "kill Robert", "kill Stan"
        );

        addTrialsForKnight(
                secondKnight, "kill Andrey", "kill Denis"
        );

        firstKnight.startTrials();
        secondKnight.startTrials();
    }

    public static void addTrialsForKnight(Knight knight, String firstTrial, String secondTrial) {
        knight.addTrial(
                new Trial(knight.getName(), firstTrial)
        );

        knight.addTrial(
                new Trial(knight.getName(), secondTrial)
        );
    }
}
