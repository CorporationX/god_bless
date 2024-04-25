package donation;

import lombok.Data;

@Data
public class Donation {
    private int id;
    private long sumOfDonation;
    private static int counterID = 1;

    public Donation(long sumOfDonation) {
        this.id = counterID;
        this.sumOfDonation = sumOfDonation;
        counterID++;
    }
}
