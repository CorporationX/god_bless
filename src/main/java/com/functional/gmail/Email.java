package com.functional.gmail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@Setter
public class Email {
    private String subject;
    private String body;
    private Boolean isImportant;

    public Boolean isImportant() {
        return isImportant;
    }
}
