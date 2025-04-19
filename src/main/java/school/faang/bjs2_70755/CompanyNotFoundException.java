package school.faang.bjs2_70755;

import java.util.NoSuchElementException;

public class CompanyNotFoundException extends NoSuchElementException {
    public CompanyNotFoundException(long id) {
        super(String.format("Company with id %d not found", id));
    }
}
