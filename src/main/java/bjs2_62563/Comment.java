package bjs2_62563;

import lombok.NonNull;

import java.time.LocalDateTime;

public record Comment(@NonNull String text, @NonNull String author, LocalDateTime timestamp) {
}
