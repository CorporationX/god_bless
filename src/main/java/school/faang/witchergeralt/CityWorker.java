package school.faang.witchergeralt;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
public class CityWorker implements Runnable {
    private static final int COORDINATE_CASTLE_X = 0;
    private static final int COORDINATE_CASTLE_Y = 0;

    private final List<Monster> monsters = new ArrayList<>();

    private City city;

    @Override
    public void run() {
        // теорема пифагора от замка до города
        // теорема пифагора от города до монстра
        log.info("");
    }
}
