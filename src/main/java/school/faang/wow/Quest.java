package school.faang.wow;

public record Quest(String name, int difficulty, int reward) {

    public int start(Quest quest) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return quest.reward;
    }
}