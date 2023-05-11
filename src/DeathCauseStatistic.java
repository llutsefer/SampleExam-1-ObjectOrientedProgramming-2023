import java.util.Arrays;

public class DeathCauseStatistic {
    private String codOfIllness;

    public int[] getNumberOfDeathsInAgeGroups() {
        return numberOfDeathsInAgeGroups;
    }

    private int[] numberOfDeathsInAgeGroups;

    public void setCodOfIllness(String codOfIllness) {
        this.codOfIllness = codOfIllness;
    }

    public String getCodOfIllness() {
        return codOfIllness;
    }

    public static DeathCauseStatistic fromCsvLine(String line) {
        DeathCauseStatistic result = new DeathCauseStatistic();
        String[] allDataArray = Arrays.stream(line.split(",")).map(e -> e.replaceAll("\\s", "")).toArray(String[]::new);
        result.setCodOfIllness(allDataArray[0]);
        result.numberOfDeathsInAgeGroups = Arrays.stream(allDataArray).skip(2).map(s -> s.replace("-", "0")).mapToInt(Integer::valueOf).toArray();
        return result;
    }
    public AgeBracketDeaths getAgeBracketDeaths(int age) {
        int minAge = (age/5)*5;
        int maxAge = ((age/5)*5)+4;
        if(minAge>=90){
            return new AgeBracketDeaths(95, 200, DeathCauseStatisticList.getDeathFromAge(age));
        }else{
            return new AgeBracketDeaths(minAge, maxAge, DeathCauseStatisticList.getDeathFromAge(age));
        }
    }
    public class AgeBracketDeaths {
        public final int young;
        public final int old;

        public int getDeathCount() {
            return deathCount;
        }

        public final int deathCount;

        public AgeBracketDeaths(int young, int old, int deathCount) {
            this.young = young;
            this.old = old;
            this.deathCount = deathCount;
        }
    }
}
