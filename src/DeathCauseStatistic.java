import java.util.Arrays;

public class DeathCauseStatistic {
    private String codOfIllness;
    private int numberOfDeathsInAgeGroups[];

    public void setCodOfIllness(String codOfIllness) {
        this.codOfIllness = codOfIllness;
    }

    public String getCodOfIllness() {
        return codOfIllness;
    }

    public static DeathCauseStatistic fromCsvLine(String line){
        DeathCauseStatistic result = new DeathCauseStatistic();
        String allDataArray[] = Arrays.stream(line.split(",")).map(e -> e.replaceAll("\\s", "")).toArray(String[]::new);
        result.setCodOfIllness(allDataArray[0]);
        result.numberOfDeathsInAgeGroups = Arrays.stream(allDataArray).skip(2).map(s -> s.replace("-", "0")).mapToInt(Integer::valueOf).toArray();
        return result;
    }
}
