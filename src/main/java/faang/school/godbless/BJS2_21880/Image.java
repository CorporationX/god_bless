package faang.school.godbless.BJS2_21880;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;

@Getter
@ToString
@AllArgsConstructor
public class Image {
    private String name;
    private String description;
    private List<Filter> filters;

    public Image(Image image) {
        this.name = image.getName();
        this.description = image.getDescription();
        this.filters = new LinkedList<>(image.getFilters());
    }

    public void add(Filter filter) {
        filters.add(filter);
    }
}
