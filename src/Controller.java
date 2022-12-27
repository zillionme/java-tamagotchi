import constants.Food;
import constants.MainMenu;
import constants.PlayMenu;
import domain.Tamagotchi;
import domain.TamagotchiService;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final TamagotchiService gameService = new TamagotchiService();
    private boolean isRunning = true;

    public void generate() {
        outputView.printStartGame();

        MainMenu mainCommand = getMainOption();
        executeMainCommand(mainCommand);
    }

    public MainMenu getMainOption() {
        int mainCommand = inputView.readMainOption();
        return MainMenu.getCommandBy(mainCommand);
    }

    public void executeMainCommand(MainMenu mainCommand) {
        if (mainCommand == MainMenu.END) {
            endGame();
        }
        if (mainCommand == MainMenu.CREATE) {
            playGame();
        }
    }

    public void playGame() {
        Tamagotchi newTamagotchi = createTamagotchi();
//        gameService.setTamagotchi(newTamagotchi);

        while (isRunning){
            PlayMenu playCommand = getPlayOption(newTamagotchi);
            executePlayCommand(newTamagotchi, playCommand);
        }
    }

    public Tamagotchi createTamagotchi() {
        String name = inputView.readCharacterName();
        return new Tamagotchi(name);
    }

    public PlayMenu getPlayOption(Tamagotchi newTamagotchi) {
        outputView.printPlayMenu(newTamagotchi);
        int playCommand = inputView.readPlayOption();

        return PlayMenu.getCommandBy(playCommand);
    }

    public void executePlayCommand(Tamagotchi tamagotchi, PlayMenu playCommand) {
        try {
            if (playCommand == PlayMenu.EAT) {
                //메뉴 프린트
                outputView.printMealMenu(tamagotchi.getMealMenu());
                int foodNumber = inputView.readFood();
                Food food = Food.getCommandBy(foodNumber);
                List<String> result = tamagotchi.eat(food);
                outputView.printResult(result);
            }
            if (playCommand == PlayMenu.WASH) {
                System.out.println("º＊♨♥상쾌하당♥♨＊º");
                System.out.println("주인님은 안씻으세요..?;＊*＊º");
                System.out.println("            º");
                System.out.println("         º");
                outputView.printResult(tamagotchi.wash());
            }
            if (playCommand == PlayMenu.SLEEP) {
                System.out.println("＊*＊＊*＊＊ º");
                System.out.println("goodNight~ZzZz");
                outputView.printResult(tamagotchi.sleep());
                Thread.sleep(1500L);
                System.out.println("\n자고 일어났더니 배고픈데요 쥔님?");
                System.out.println("       º");
                System.out.println("         º");
            }
            if (playCommand == PlayMenu.WALK) {
                System.out.println("운동 좀 할게요~");
                System.out.println("＊*＊＊*＊＊ º");
                outputView.printStatus(tamagotchi.walk());
                Thread.sleep(1500L);
                System.out.println("            º");
                System.out.println(" 씻고싶네요   º");
            }
            if (playCommand == PlayMenu.LOOKUP_STATUS) {
                outputView.printStatus(tamagotchi.getStatus());
            }
            if (playCommand == PlayMenu.END) {
                endGame();
            }
        } catch(InterruptedException e) {
        }
    }

    public void endGame() {
        isRunning = false;
        outputView.printEnd();
    }


}
