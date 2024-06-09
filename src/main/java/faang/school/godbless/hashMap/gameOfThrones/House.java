package faang.school.godbless.hashMap.gameOfThrones;

import lombok.Data;

@Data
public class House {
    private String name;
    private String sigil;

    public House(String name, String sigil) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Name can`t be null or empty");
        }
        if (sigil == null || sigil.isEmpty() || sigil.isBlank()) {
            throw new IllegalArgumentException("Sigil can`t be null or empty");
        }
        this.name = name;
        this.sigil = sigil;
    }

    @Override
    public String toString() {
        return "House: " + name + ", sigil: " + sigil;
    }
}