package faang.school.godbless.instagram;

import lombok.Data;

@Data
public class Image {
    private String url;
    private String name;

    Image(String url, String name) {
        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("url cannot be null or empty");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name cannot be null or empty");
        }

        this.url = url;
        this.name = name;
    }
}
