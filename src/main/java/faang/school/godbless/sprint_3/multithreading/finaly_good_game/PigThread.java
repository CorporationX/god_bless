package faang.school.godbless.sprint_3.multithreading.finaly_good_game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PigThread extends Thread {
    private String pigName;
    private int material;
    private final List<String> homeMaterials = List.of("солома", "палки", "кирпичи");
}
