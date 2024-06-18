package faang.school.godbless;

public class Image {
    private String name;
    private String description;

    public Image(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Image " +
                "name = " + name +
                ", description = " + description;
    }
}