package view;

import domain.Tamagotchi;

import java.util.List;

public class OutputView {
    public static final List<String> LOADING = List.of("+＊*＊( '▽') ＊*＊",
            "*  다마고치 키우기  *", "+＊*＊( '▽') ＊*＊");
    public static final List<String> START_MENU = List.of("\n0.게임 종료하기", "1.다마고치 생성하기");
    private static final String TAMAGOTCHI_BEGIN = "\n＊*＊+＊*＊+＊*＊+＊*＊+\n";
    private static final String PLAY_OPTION =
            "%s를 돌봐주세요.\n" +
                    "1.먹이주기\n" +
                    "2.씻겨주기\n" +
                    "3.재우기\n" +
                    "4.산책하기\n" +
                    "5.상태보기\n" +
                    "0.나가기\n";

    public void printLoadGame() {
        try {
            for (String each : LOADING) {
                System.out.println(each);
                Thread.sleep(500L);
            }
        } catch (InterruptedException e) {
        }
    }

    public void printStartGame() {
        printLoadGame();
        for (String each : START_MENU) {
            System.out.println(each);
        }
    }

    public void printPlayMenu(Tamagotchi tamagotchi) {
        System.out.println(TAMAGOTCHI_BEGIN);
        //다마고치 이미지 프린트
        printTamagotchi(tamagotchi);
        System.out.printf(PLAY_OPTION + "\n", tamagotchi.getName());
    }

    public void printTamagotchi(Tamagotchi tamagotchi) {
        try {
            for (String each : tamagotchi.getPicture()) {
                System.out.println(each);
                Thread.sleep(300L);
            }
        } catch (InterruptedException e) {
        }
    }

    public void printMealMenu(List<String> menu) {
        for (String each : menu) {
            System.out.println(each);
        }
    }

    public void printResult(List<String> result) {
        try {
            for (String each : result) {
                System.out.print(each);
                Thread.sleep(800L);
            }
        } catch (InterruptedException e) {
        }
    }

    public void printStatus(List<String> status) {
        for (String each : status) {
            System.out.println(each);
        }

    }

    public void printEnd() {
        System.out.println("게임을 종료합니다.");
    }

}
