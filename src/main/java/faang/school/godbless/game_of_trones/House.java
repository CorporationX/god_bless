package faang.school.godbless.game_of_trones;

public class House {
    private  String name;
    private String emblem;

    public House(String name, String emblem) {
        this.name = name;
        this.emblem = emblem;
    }

    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                ", emblem='" + emblem + '\'' +
                '}';
    }
}
