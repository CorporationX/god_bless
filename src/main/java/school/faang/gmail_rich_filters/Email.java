package school.faang.gmail_rich_filters;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.NonNull;

/**
 * Проект: god_bless
 * Класс Email
 * Автор: Vital
 * Дата: 22.09.2025
 */

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Email {
    @NonNull private String subject;
    @NonNull private String body;
    private Boolean isImportant;
}