package school.faang.instagramfilter;

public class Image {
    private final String name;
    private final String description;

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
}
