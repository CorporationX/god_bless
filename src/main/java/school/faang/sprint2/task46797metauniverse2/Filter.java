package school.faang.sprint2.task46797metauniverse2;


import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@EqualsAndHashCode
@Getter
class Filter {
    private final String typeFilter;
    private final List<Notification> filteredNotifications = new ArrayList<>();

    public Filter(String typeFilter) {
        this.typeFilter = typeFilter;
    }

    public void addFilteredNotifications(Notification notification) {
        filteredNotifications.add(notification);
    }
}
