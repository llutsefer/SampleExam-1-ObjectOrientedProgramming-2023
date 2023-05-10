import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            DeathCauseStatisticList.repopulate(Path.of("data/zgony.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ArrayList<DeathCauseStatistic> resultOfMostDeadlyDiseasesTest = DeathCauseStatisticList.mostDeadlyDiseases(25, 5);
        for (DeathCauseStatistic x:resultOfMostDeadlyDiseasesTest
             ) {
                System.out.println(x.getCodOfIllness());
        }
        System.out.println(DeathCauseStatisticList.getDeathFromAge(96));
        System.out.println(DeathCauseStatisticList.getDeathFromAge(0));
        DeathCauseStatistic.AgeBracketDeaths ageBracketDeathsTest = DeathCauseStatisticList.deathCauseStatisticArrayList.get(0).getAgeBracketDeaths(5);
        System.out.println(ageBracketDeathsTest.getDeathCount());
        ICDCodeTabularOptimizedForTime icdCodeTabularOptimizedForTimeTest = new ICDCodeTabularOptimizedForTime();
        System.out.println(icdCodeTabularOptimizedForTimeTest.getDescription("S66.0"));
        ICDCodeTabularOptimizedForMemory icdCodeTabularOptimizedForMemoryTest = new ICDCodeTabularOptimizedForMemory();
        System.out.println(icdCodeTabularOptimizedForMemoryTest.getDescription("S66.0"));
    }
}