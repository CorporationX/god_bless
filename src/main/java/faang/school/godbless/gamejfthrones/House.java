package faang.school.godbless.gamejfthrones;

public record House(String name, String sigil) {
    public House {
        validate(name, sigil);
    }

    private void validate(String name, String sigil) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("House name can't be null or empty");
        }
        if (sigil == null) {
            throw new IllegalArgumentException("House sigil can't be null");
        }
    }
}
