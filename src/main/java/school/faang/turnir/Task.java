package school.faang.turnir;

public record Task(String name, Integer difficulty, Integer reward) {

    public Integer runTask() {
        try {
            Thread.sleep(difficulty * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.reward;
    }
}
