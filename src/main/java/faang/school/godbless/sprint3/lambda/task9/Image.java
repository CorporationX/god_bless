package faang.school.godbless.sprint3.lambda.task9;

import java.util.Objects;

public class Image {
    private String name;
    private String description;

    public Image(String fileName, String description) {
        this.name = fileName;
        this.description = description;
    }

    public String getName() {
        return name;
    } 

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return Objects.equals(name, image.name) && Objects.equals(description, image.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }
}
