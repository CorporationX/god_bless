package school.faang.synchronization.bjs2_73462;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestData {
    protected static final List<Room> ROOMS_WITH_FOOD = new ArrayList<>(List.of(
            new Room(1, new ArrayList<>(List.of(
                    new Food("food1-1"),
                    new Food("food1-6"),
                    new Food("food1-2"),
                    new Food("food1-3"),
                    new Food("food1-4"),
                    new Food("food1-5")
            ))),
            new Room(2, new ArrayList<>(List.of(
                    new Food("food2-1"),
                    new Food("food2-6"),
                    new Food("food2-2"),
                    new Food("food2-3"),
                    new Food("food2-4"),
                    new Food("food2-5")
            ))),
            new Room(3, new ArrayList<>(List.of(
                    new Food("food3-1"),
                    new Food("food3-6"),
                    new Food("food3-2"),
                    new Food("food3-3"),
                    new Food("food3-4"),
                    new Food("food3-5")
            ))),
            new Room(4, new ArrayList<>(List.of(
                    new Food("food4-1"),
                    new Food("food4-6"),
                    new Food("food4-2"),
                    new Food("food4-3"),
                    new Food("food4-4"),
                    new Food("food4-5")
            ))), new Room(5, new ArrayList<>(List.of(
                    new Food("food5-1"),
                    new Food("food5-6"),
                    new Food("food5-2"),
                    new Food("food5-3"),
                    new Food("food5-4"),
                    new Food("food5-5")
            ))),
            new Room(6, new ArrayList<>(List.of(
                    new Food("food6-1"),
                    new Food("food6-6"),
                    new Food("food6-2"),
                    new Food("food6-3"),
                    new Food("food6-4"),
                    new Food("food6-5")
            ))),
            new Room(7, new ArrayList<>(List.of(
                    new Food("food7-1"),
                    new Food("food7-6"),
                    new Food("food7-2"),
                    new Food("food7-3"),
                    new Food("food7-4"),
                    new Food("food7-5")
            ))),
            new Room(8, new ArrayList<>(List.of(
                    new Food("food8-1"),
                    new Food("food8-6"),
                    new Food("food8-2"),
                    new Food("food8-3"),
                    new Food("food8-4"),
                    new Food("food8-5")
            ))), new Room(9, new ArrayList<>(List.of(
                    new Food("food9-1"),
                    new Food("food9-6"),
                    new Food("food9-2"),
                    new Food("food9-3"),
                    new Food("food9-4"),
                    new Food("food9-5")
            ))),
            new Room(10, new ArrayList<>(List.of(
                    new Food("food10-1"),
                    new Food("food10-6"),
                    new Food("food10-2"),
                    new Food("food10-3"),
                    new Food("food10-4"),
                    new Food("food10-5")
            )))
    ));
}
