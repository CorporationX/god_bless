package faang.school.godbless.BJS2_9828;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Image {
    private String name;
    private String description = "Оригинальное изображение";
    private List<String> appliedFilters = new ArrayList<>();

    public Image(String name, String description) {
        this.name = name;
        this.appliedFilters.add(description);
    }

    public void showAppliedFilters() {
        appliedFilters.forEach(description -> System.out.println(description));
    }
}
