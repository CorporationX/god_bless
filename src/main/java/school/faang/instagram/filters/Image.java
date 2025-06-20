package school.faang.instagram.filters;

public class Image {
    String name;
    String description;

    Image(String n, String d) {
        this.name = n;
        this.description = d;
    }

    Image withDesc(String d) {
        return new Image(name, d);
    }
}
