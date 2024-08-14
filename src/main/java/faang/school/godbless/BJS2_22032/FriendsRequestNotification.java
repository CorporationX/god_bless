package faang.school.godbless.BJS2_22032;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class FriendsRequestNotification extends Notification {
    private String friendName;
    private String requestTime;

    public FriendsRequestNotification(String message, String friendName) {
        super("FRIEND_REQUEST", message);
        this.friendName = friendName;
        this.requestTime = DateTimeFormatter.ofPattern("HH:mm").format(LocalTime.now());
    }
}
