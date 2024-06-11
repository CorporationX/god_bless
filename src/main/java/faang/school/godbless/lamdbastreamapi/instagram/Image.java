package faang.school.godbless.lamdbastreamapi.instagram;

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

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Image{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
