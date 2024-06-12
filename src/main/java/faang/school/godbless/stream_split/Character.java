package faang.school.godbless.stream_split;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@RequiredArgsConstructor
@Setter
@Getter
@ToString
public class Character {

    private final String name;

    private List<Item> inventory;

}
