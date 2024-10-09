package org.example.model.googleRichFilter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;
}
