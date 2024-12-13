package ru.maks1979.task_46427;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Image {
    @Setter
    private String name;
    @Setter
    private String description;

    public Image(String name, String description) {
        this.name = name;
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
