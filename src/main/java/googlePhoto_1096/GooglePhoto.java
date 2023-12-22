package googlePhoto_1096;

import lombok.Data;

@Data
public class GooglePhoto {
    private int id;
    private String photoPath;

    public GooglePhoto(int id, String photoPath) {
        this.id = id;
        this.photoPath = photoPath;
    }
}
