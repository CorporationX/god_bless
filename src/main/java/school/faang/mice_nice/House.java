package school.faang.mice_nice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
public class House {
    private final List<Room> rooms;

    public void collectFood() {

    }

}
