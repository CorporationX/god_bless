package school.faang.helpanimal;

public record Donation(int id, int amount) {
    private static int currentId = 1;

    public Donation(int amount) {
        this(currentId++, amount);
    }
}
