package faang.school.godbless.InstagramFilter;

public class Image {
    private String name;
    private String description;

    public Image(String imageFileName, String imageDescription) {
        this.name = imageFileName;
        this.description = imageDescription;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return "Filename - " + name + ". Description - " + description;
    }
}
