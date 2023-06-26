package faang.school.godbless.igFilters;

import lombok.Getter;

@Getter
public class Image {
    private static final String ERROR_EMPTY_FILENAME = "The file name can't be empty";

    private String name;
    private String description;

    public Image(String fileName, String description) {
        validateFileName(fileName);
        this.name = fileName;
        this.description = description;
    }

    private void validateFileName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_FILENAME);
        }
    }

}
