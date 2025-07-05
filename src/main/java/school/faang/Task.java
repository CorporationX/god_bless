package school.faang.bjs2_82905;

class Task {
    private final String name;
    private final int difficulty;

    public Task(String name, int difficulty) {
        this.name = name;
        this.difficulty = difficulty;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public String getName() {
        return name;
    }
}

