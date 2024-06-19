package faang.school.godbless.multithreading_parallelism.task_7;

import lombok.NonNull;

public record Location(int x, int y) {

    public int compareLocation(@NonNull Location otherLocation, @NonNull Location referenceLocation) {
        final int thisLocationDistance = Math.abs(this.x - referenceLocation.x) + Math.abs(this.y - referenceLocation.y);
        final int otherLocationDistance = Math.abs(otherLocation.x - referenceLocation.x) + Math.abs(otherLocation.y - referenceLocation.y);
        return Integer.compare(thisLocationDistance, otherLocationDistance);
    }
}
