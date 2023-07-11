package faang.school.godbless.google_photo_sync;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GooglePhoto {
    private String name;

    public String toString() {
        return this.getName();
    }
}



