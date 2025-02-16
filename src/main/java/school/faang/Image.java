package school.faang;

public class Image {
    private String name;
    private String description;

    public Image(String name, String description) {
        this.name = name;
        this.description = "Original image";
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}


