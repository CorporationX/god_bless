package faang.school.godbless.SecondSprint.BJS2_21331;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
@ToString
public class Character {
    @NonNull
    private String name;
    private List<Item> inventory = new ArrayList<>();
}
