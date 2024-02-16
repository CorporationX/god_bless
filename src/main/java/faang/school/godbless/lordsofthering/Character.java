package faang.school.godbless.lordsofthering;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Character {

    @NonNull
    private String name;
    private List<Item> inventory = new ArrayList<>();
}
