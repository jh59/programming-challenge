package de.exxcellent.challenge;

import de.exxcellent.challenge.resolution.Challenge;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // Your preparation code …
        String pathWeatherFile = "src/main/resources/de/exxcellent/challenge/weather.csv";
        String pathFootballFile = "src/main/resources/de/exxcellent/challenge/football.csv";
        Challenge weatherChallenge = new Challenge(pathWeatherFile, "Day", "MxT", "MnT");
        Challenge footballChallenge = new Challenge(pathFootballFile, "Team", "Goals", "Goals Allowed");

        String dayWithSmallestTempSpread = weatherChallenge.returnSmallestSpread();     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        String teamWithSmallestGoalSpread = footballChallenge.returnSmallestSpread(); // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
