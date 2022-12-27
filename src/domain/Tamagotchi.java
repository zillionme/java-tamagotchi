package domain;

import constants.Food;
import constants.MealMenu;

import java.util.List;

public class Tamagotchi {
    private final String name;
    private int level = 0;
    private int point = 100;
    private int love = 7;
    private int satiety = 7;
    private int experience = 0;

    public Tamagotchi(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getMealMenu() {
        return MealMenu.getMenuBy(point, level);
    }

    public boolean isAbleToEat() {
        return point >=50;
    }

    public List<String> getPicture() {
        return TamagotchiPicture.pictureBy(level);
    }

    public List<String> eat(Food food) {
        point -= food.getPointToUse();
        satiety += food.getSatietyToAdd();
        love += 1;
        experience +=1;

        return List.of(
                String.format("______________________________________\n" +
                        "| 포만감 -%s!", satiety),
                "애정 +1!",
                String.format("포인트 -%s!", point),
                "경험치 +1! |",
                "\n냠냠굿~주인님＊*＊º",
                "\n            º\n         º\n");
    }

    public List<String> wash() {
        love += 1;
        experience +=1;
        return List.of("_________________\n" +
                "| 경험 +1!",
                "애정 +1! |\n");
    }

    public List<String> sleep() {
        experience++;
        satiety--;
        point +=20;
        love--;
        return List.of("__________________________________\n" +
                        "| 경험 +1!",
                "포만감 -1!",
                "포인트 +20!",
                "애정 -1! |\n"
        );
    }
    public List<String> walk() {
        experience += 2;
        satiety--;
        point += 30;
        love ++;

        return List.of("__________________________________\n" +
                        "| 경험 +2!",
                "포만감 -1!",
                "포인트 +30!",
                "애정 -1! |\n"
        );
    }



        public List<String> getStatus() {
        return List.of(
                String.format("%s의 상태", name),
                String.format("Lv.%s/3", level),
                String.format("애정도 : %s/10", love),
                String.format("포만감 : %s/10", satiety),
                "POINT : "+point,
                "경험치 : "+experience
                );
    }
}
