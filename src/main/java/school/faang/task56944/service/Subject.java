package school.faang.task56944.service;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Subject {
    @NonNull
    private String name;
}
