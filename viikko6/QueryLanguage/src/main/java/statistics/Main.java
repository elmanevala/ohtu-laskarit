package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("https://nhlstatisticsforohtu.herokuapp.com/players.txt"));

        Matcher m = new And(
                new HasFewerThan(1, "goals"),
                new PlaysIn("NYR")
        );

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
        
        System.out.println(stats.matches(new All()).size());

    }
}