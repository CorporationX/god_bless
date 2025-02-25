package school.faang.sprint4.task_63939;


public record Quest(String name, int difficulty, int reward) {
    private static final long QUEST_TIME_MS = 1000L;
    private static final int DIFFICULTY_TO_EXPERIENCE_CONVERTER = 10;

    public int startQuest() {
        try {
            Thread.sleep(QUEST_TIME_MS * difficulty / 2);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return difficulty * DIFFICULTY_TO_EXPERIENCE_CONVERTER;
    }
}
