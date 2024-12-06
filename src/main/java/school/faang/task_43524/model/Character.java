package school.faang.task_43524.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class Character {
    private final String name;
    private List<Item> items = new ArrayList<>();
}