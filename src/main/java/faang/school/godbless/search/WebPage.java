package faang.school.godbless.search;

import lombok.NonNull;

public record WebPage(@NonNull String url, @NonNull String title, @NonNull String content) {
}
