package school.faang.bjs2_87774;

public record Image(String name, String description) {

    @Override
    public String toString() {
        return name + " " + description;
    }
}
