package sprint3task3;

import lombok.Data;

@Data
public class Image {
    //будет представлять фотографию пользователя
    private String name;
    private String description;

    public Image(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
