package school.faang;

import lombok.Getter;

@Getter
public class PigThread extends Thread {
    private final String pigName;
    public final String material;

    public PigThread(String pigName, String material) {
        isValidString(pigName, "Pig name");
        isValidString(material, "Material");
        this.pigName = pigName;
        this.material = material;
    }

    private void isValidString(String string, String message) {
        if (string == null || string.isBlank()) {
            throw new IllegalArgumentException(message + " can't be null or empty.");
        }
    }
}
