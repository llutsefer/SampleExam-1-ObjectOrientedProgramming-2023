import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class DeathCauseStatisticList {
    public static ArrayList<DeathCauseStatistic> deathCauseStatisticArrayList = new ArrayList<>();

    public static void repopulate(Path pathToCSV) throws IOException {
        deathCauseStatisticArrayList.clear();
        Scanner sc = new Scanner(pathToCSV);
        sc.nextLine();
        sc.nextLine();
        while (sc.hasNextLine()) {
            deathCauseStatisticArrayList.add(DeathCauseStatistic.fromCsvLine(sc.nextLine()));
        }
        sc.close();
    }

    public static ArrayList<DeathCauseStatistic> mostDeadlyDiseases(int age, int n){
        ArrayList<DeathCauseStatistic> result = new ArrayList<>();
        ArrayList<DeathCauseStatistic> copyOfDeathCauseStatisticArrayList = new ArrayList<>(deathCauseStatisticArrayList);
        int indexOfAge = age/5;
        for(int i = 0; i < n; i++){
            int max = copyOfDeathCauseStatisticArrayList.get(0).getNumberOfDeathsInAgeGroups()[indexOfAge];
            int maxIndex = 0;
            for(int j = 0;j< copyOfDeathCauseStatisticArrayList.size(); j++){
                if(copyOfDeathCauseStatisticArrayList.get(j).getNumberOfDeathsInAgeGroups()[indexOfAge] > max){
                    max = copyOfDeathCauseStatisticArrayList.get(j).getNumberOfDeathsInAgeGroups()[indexOfAge];
                    maxIndex = j;
                }
            }
            result.add(copyOfDeathCauseStatisticArrayList.get(maxIndex));
            copyOfDeathCauseStatisticArrayList.remove(maxIndex);
        }
        return result;
    }

    public static int getDeathFromAge(int age){
        int indexOfAge = age/5;
        int result = 0;
        for(DeathCauseStatistic dcs : deathCauseStatisticArrayList){
            result += dcs.getNumberOfDeathsInAgeGroups()[indexOfAge];
        }
        return result;
    }

}
