package google_photo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class GooglePhoto {
    private List<String> myPhoto;
    public GooglePhoto(){
        myPhoto = new ArrayList<>();
    }
}
