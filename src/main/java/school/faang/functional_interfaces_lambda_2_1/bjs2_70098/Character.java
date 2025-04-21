package school.faang.functional_interfaces_lambda_2_1.bjs2_70098;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
class Character {
    private final String name;
    private final List<Item> inventory;
}
