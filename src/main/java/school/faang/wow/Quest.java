package school.faang.wow;

public record Quest(String name, int difficulty, int reward) {
    public int getPoints() {
        return difficulty * reward;
    }
}
