package faang.school.godbless.thread6;

public class King {
    public static void main(String[] args) {
        Knight richard = new Knight("Ричард");
        Knight gottfried = new Knight("Готфрид");
        addTrialForKnight(richard, gottfried);
        richard.startTrials();
        gottfried.startTrials();
    }

    private static void addTrialForKnight(Knight richard, Knight gottfried) {
        richard.addTrial(new Trial(richard.name(), "Победить дракона"));
        richard.addTrial(new Trial(richard.name(), "Найти сокровище"));
        gottfried.addTrial(new Trial(gottfried.name(), "Победить дракона"));
        gottfried.addTrial(new Trial(gottfried.name(), "Найти сокровище"));
    }


}
