package googlePhoto_1096;

import lombok.Data;

@Data
public class GooglePhoto {
    private static int count = 0;
    private  int id;
    private String photoPath;

    public GooglePhoto(String photoPath) {
        this.photoPath = photoPath;
        this.id = ++count;
    }
}