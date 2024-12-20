package school.faang.sprint_3.task_bjs248925;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@UtilityClass
public class TestDataGenerator {
    private int fileIndex = 0;

    public List<String> generatePhotoPaths(int capacity) {
        List<String> list = IntStream.range(0, capacity)
                .mapToObj(counter -> generateSinglePhotoPath())
                .toList();
        return new ArrayList<>(list);
    }

    public String generateSinglePhotoPath() {
        String photo = "Photo " + fileIndex;
        fileIndex++;
        return photo;
    }
}
