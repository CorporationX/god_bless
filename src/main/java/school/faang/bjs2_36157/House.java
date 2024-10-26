package school.faang.bjs2_36157;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Getter
@Slf4j
public class House {
    private final List<Room> rooms = new ArrayList<>();

    public void addRooms(List<Room> rooms) {
        this.rooms.addAll(rooms);
    }
}