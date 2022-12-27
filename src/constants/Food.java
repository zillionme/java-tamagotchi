package constants;

import java.util.Arrays;

public enum Food {
    RICE_AND_KIMCHI(1, 50, 1),
    RAMEN(2, 50, 1),
    PORK_CUTLET(3 ,80, 3),
    SOY_CRAB(4, 100, 4),
    GALBIZZIM(5, 150, 10),
    NOTHING(0,0,0);

    private final int matchingNumber;
    private final int pointToUse;
    private final int satietyToAdd;

    Food(int matchingNumber, int pointToUse, int satietyToAdd) {
        this.matchingNumber = matchingNumber;
        this.pointToUse = pointToUse;
        this.satietyToAdd = satietyToAdd;
    }

    public int getPointToUse() {
        return pointToUse;
    }

    public int getSatietyToAdd() {
        return satietyToAdd;
    }

    public static Food getCommandBy(int input) {
        return Arrays.stream(values())
                .filter(command-> command.matchingNumber == input)
                .findFirst()
                .get();
    }
}
