package school.faang.task57706.service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Notification {
    NotificationType type;
    String message;
}