package domain;

import constants.MainMenu;

import java.util.HashSet;
import java.util.Set;

public class TamagotchiService {
    //다마고치 생성하기
    //이름짓기
    //다마고치 어디 저장할거임?
//    private final Set<Tamagotchi> tamagotchiRepository = new HashSet<>();
    private Tamagotchi userTamagotchi;
    private boolean isRunning = true;

//    public void executeMainCommand(MainMenu mainCommand) {
//        if(mainCommand == MainMenu.END) {
//            isRunning = false;
//        }
//        if(mainCommand == MainMenu.CREATE) {
//
//        }
//    }

    public boolean isRunning() {
        return isRunning;
    }
    public void setTamagotchi(Tamagotchi tamagotchi) {
        userTamagotchi = tamagotchi;
    }

//    public void addNewCharacter(Tamagotchi tamagotchi) {
//        tamagotchiRepository.add(tamagotchi);
//    }


}
