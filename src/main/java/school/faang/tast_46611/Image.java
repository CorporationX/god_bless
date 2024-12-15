package school.faang.tast_46611;

import lombok.Getter;

public class Image {
    @Getter private String name;
    @Getter private String description;

    public Image(String name, String description) {
        if (name.trim().isEmpty() || description.trim().isEmpty()) {
            System.out.println("Name and Description cannot be empty");
        }
        this.name = name;
        this.description = description;
    }
}
