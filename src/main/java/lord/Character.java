package lord;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class Character {
    private final String name;

    @Getter
    private List<Item> inventory = new ArrayList<>();
}
