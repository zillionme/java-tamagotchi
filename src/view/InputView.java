package view;

import java.util.Scanner;

public class InputView {
    private static final String MESSAGE_INPUT = "해당하는 번호를 입력해주세요 : ";

    private final Scanner sc = new Scanner(System.in);

    public int readMainOption() {
        System.out.print(MESSAGE_INPUT);
        int input = sc.nextInt();
        //유효성 검사
        return input;
    }

    public String readCharacterName() {
        System.out.print("다마고치의 이름을 지어주세요(수정불가) : ");
        String input = sc.nextLine();
        return input.trim();
    }

    public int readPlayOption() {
        System.out.print(MESSAGE_INPUT);
        int input = sc.nextInt();
        //유효성 검사
        return input;
    }

    public int readFood() {
        return sc.nextInt();
    }
}
