package instagram_800;

import lombok.Data;

@Data
public class Image {
    private String name;
    private String data;

    public Image(String name, String data) {
        this.name = name;
        this.data = data;
    }
}