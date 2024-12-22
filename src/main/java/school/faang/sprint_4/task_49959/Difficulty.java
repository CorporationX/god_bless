package school.faang.sprint_4.task_49959;

public enum Difficulty {
    EASY(2000),
    MEDIUM(3000),
    HARD(4000);

    private final int timeToComplete;

    Difficulty(int timeToComplete) {
        this.timeToComplete = timeToComplete;
    }

    public int getTimeToComplete() {
        return timeToComplete;
    }
}
