package school.faang.bjs2_89600;

public class Knight {
    private String name;
    private List<Trial> trials;

    public Knight(String name) {
        this.name = name;
    }

    public static void addTrial(Trial trial) {
        trials.add(trial);
    }

    public static void startTrials() {
        //Здесь нужно будет запустить испытания
    }
}
