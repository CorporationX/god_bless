package school.faang.bjs2_83012;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Comment {
    @NonNull
    private String text;
    @NonNull
    private User author;
    @NonNull
    private LocalDateTime createdAt;
}
