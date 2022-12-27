package constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

public enum MealMenu {
    MEAL_FOR_UNDER_FIFTY((point, level)-> point < 50 , "식사를 할 포인트가 충분하지 않습니다."),
    MEAL_FOR_UNDER_EIGHTY((point, level)-> point < 80, "1. 밥과 김치(-50P) (+1 Full)\n 2. 라면(-50P) (+1 Full)"),
    MEAL_FOR_UNDER_HUNDRED((point, level)-> level >= 1 && point < 100, "3. 돈까스(-80P) (+3 Full)"),
    MEAL_FOR_UNDER_HUNDRED_FIFTY((point, level)-> level >= 2 && point < 150, "4. 간장게장(-100P) (+4 Full)"),
    MEAL_FOR_OVER_HUNDRED_FIFTY((point, level)-> level >= 3 && point >= 150, "5. 갈비찜(-150P) (+10 Full)");

    private final BiPredicate<Integer,Integer> predicate;
    private final String menu;

    MealMenu(BiPredicate<Integer,Integer> predicate, String menu) {
        this.predicate = predicate;
        this.menu = menu;
    }

    public static List<String> getMenuBy(int point, int level) {
        List<String> menu = new ArrayList<>();
        Arrays.stream(values())
                .filter(mealMenu -> mealMenu.predicate.test(point, level))
                .forEach(mealMenu -> menu.add(mealMenu.menu));
        menu.add("0. 안 먹기");

        return menu;
    }
}
