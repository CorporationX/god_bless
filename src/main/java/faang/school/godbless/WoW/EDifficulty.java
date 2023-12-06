package faang.school.godbless.WoW;

public enum EDifficulty {
    EASY(1000), NORMAL(2000), HARD(3000);

    private final int duration;

    EDifficulty(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }
}
