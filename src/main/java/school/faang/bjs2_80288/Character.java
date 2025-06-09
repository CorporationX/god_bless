package school.faang.bjs2_80288;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public class Character {
    @NonNull
    private String name;
    private List<Item> inventory = new ArrayList<>();
}
