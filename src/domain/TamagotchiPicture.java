package domain;

import java.util.Arrays;
import java.util.List;

public enum TamagotchiPicture {
    LEVEL0(0, List.of("     ___  ", "    /_ _\\  ", "   |  ○  | ", "    \\___/ ")),
    LEVEL1(1, List.of("  \" ___  \"", "\"  /= =\\  \"", " \\|  ▼  |/", "   \\___/")),
    LEVEL2(2, List.of("    ___  ", " ♥ /● ●\\ ♥", " \\|  ▼  |/", "   \\___/", "    W W")),
    LEVEL3(3, List.of("   _■■■  ♪", "  ♬  /> <\\  ", " \\|  ▼  |/", "   \\___/", "  ♥_| |_♥"));

    private final int level;
    private final List<String> picture;

    TamagotchiPicture(int level, List<String> picture) {
        this.level = level;
        this.picture = picture;
    }

    public static List<String> pictureBy(int input) {
        return Arrays.stream(values())
                .filter(tamagotchiPicture -> tamagotchiPicture.level == input)
                .findFirst()
                .get()
                .picture;
    }
}
