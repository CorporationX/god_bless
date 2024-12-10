package school.faang.sprint_2.task_bjs246345;

import java.util.ArrayList;
import java.util.List;

public record Image(String name, List<ImageDescription> descriptions) {
    public Image(String name) {
        this(name, new ArrayList<>());
    }

    public Image addNewDescription(ImageDescription additionalDescription) {
        List<ImageDescription> updatedDescriptions = new ArrayList<>(this.descriptions);
        updatedDescriptions.add(additionalDescription);
        return new Image(this.name, updatedDescriptions);
    }
}
