package faang.school.godbless.lordOfTheRings;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Character {
    @NonNull
    private String name;
    private List<Item> inventory;
}
