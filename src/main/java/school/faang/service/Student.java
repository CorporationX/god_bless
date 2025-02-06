package school.faang.service;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Student {
    @NonNull
    private String name;
}
