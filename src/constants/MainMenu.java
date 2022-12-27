package constants;

import java.util.Arrays;

public enum MainMenu {
    END(0),
    CREATE(1);

    private final int matchingNumber;

    MainMenu(int matchingNumber) {
        this.matchingNumber = matchingNumber;
    }


    public static MainMenu getCommandBy(int input) {
        return Arrays.stream(values())
                .filter(command-> command.matchingNumber == input)
                .findFirst()
                .get();
    }
}
