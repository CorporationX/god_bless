package school.faang.triwizardtournament;

public record Task(String name, int difficulty, int reward) {
    public long getJoinTime() {
        return difficulty * 1000L;
    }
}
