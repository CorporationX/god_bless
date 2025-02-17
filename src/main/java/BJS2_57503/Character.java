package BJS2_57503;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class Character {
    private final String name;
    private List<Item> inventory = new ArrayList<>();
}
