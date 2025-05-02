package school.faang.bjs2_73528;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public final class House {
    @Getter
    private final String name;
    private final List<Room> rooms;

    public List<Room> getRooms() {
        return new ArrayList<>(rooms);
    }
}
