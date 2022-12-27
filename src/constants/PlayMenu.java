package constants;

import java.util.Arrays;

public enum PlayMenu {
    EAT(1),
    WASH(2),
    SLEEP(3),
    WALK(4),
    LOOKUP_STATUS(5),
    END(0);

    private final int matchingNumber;

    PlayMenu(int matchingNumber) {
        this.matchingNumber = matchingNumber;
    }


    public static PlayMenu getCommandBy(int input) {
        return Arrays.stream(values())
                .filter(command-> command.matchingNumber == input)
                .findFirst()
                .get();
    }
}
