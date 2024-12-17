package school.faang.task_48194;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Location(int x, int y) {
    public double findDistance(Location location) {
        return Math.sqrt(Math.pow(location.x() - x(), 2)
                + Math.pow(location.y() - y(), 2));
    }
}
