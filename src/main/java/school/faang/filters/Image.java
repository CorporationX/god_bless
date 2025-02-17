package school.faang.filters;

import lombok.Data;

@Data
public class Image {
    private final String name;
    private final String description;

    public Image applyFilter(String filterName) {
        return new Image(this.name, this.description + "+" + filterName);
    }
}
