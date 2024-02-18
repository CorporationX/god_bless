package faang.school.godbless.InstagramFilters;

import lombok.Getter;

@Getter
public class Image {
    String nameFiles, description;

    public Image(String nameFiles, String description) {
        this.description = description;
        this.nameFiles = nameFiles;
    }
}
