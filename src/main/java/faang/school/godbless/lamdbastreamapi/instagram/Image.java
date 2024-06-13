package faang.school.godbless.lamdbastreamapi.instagram;

public record Image(String name, String description) {

    public Image(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
