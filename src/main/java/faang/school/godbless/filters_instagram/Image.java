package faang.school.godbless.filters_instagram;

public record Image(String name,
                    String description) {

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Image{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
