package school.faang.double_cache;


public record Subject(String name) {

    public String getName() {
        return name();
    }
}
