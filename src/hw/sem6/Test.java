package hw.sem6;

import java.util.HashMap;
import java.util.Map;

public class Test {
    private static final int NUMB_GAMES = 1000;

    public static void main(String[] args) {
        Map<String, Integer> results = new HashMap<>();
        results.put("Wins", 0);
        results.put("Losses", 0);

        for (int i = 0; i < NUMB_GAMES; i++) {
            if (GameMonty.start()) {
                results.put("Wins", results.get("Wins") + 1);
            } else {
                results.put("Losses", results.get("Losses") + 1);
            }
        }

        System.out.println("Results after " + NUMB_GAMES + " games:");
        System.out.println("Wins: " + results.get("Wins"));
        System.out.println("Losses: " + results.get("Losses"));
    }
}
