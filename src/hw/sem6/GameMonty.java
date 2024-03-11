package hw.sem6;

import java.util.Random;

public class GameMonty {
    private static final Random random = new Random();

    public static boolean start() {
        int prizeDoor = random.nextInt(3);
        int userChosenDoor = random.nextInt(3);

        int showDoor;
        do {
            showDoor = random.nextInt(3);
        } while (showDoor == prizeDoor || showDoor == userChosenDoor);

        int finalChoice = userChosenDoor;

        return finalChoice == prizeDoor;
    }
}
