package Sprint_2.BJS2_34985;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Image {

    private String name;
    private String description;

    public Image(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void updateDescription(String newDescription) {
        this.description = this.description + newDescription; // Добавляем к существующему описанию
    }
}

