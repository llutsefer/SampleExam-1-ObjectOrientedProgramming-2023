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

    public class AgeBracketDeaths{
        public final int young;
        public final int old;
        public final int deathCount;

        public AgeBracketDeaths(int young, int old, int deathCount) {
            this.young = young;
            this.old = old;
            this.deathCount = deathCount;
        }

        public AgeBracketDeaths getAgeBracketDeaths(int age) {
            if (age >= 0 && age <= 4) {
                return new AgeBracketDeaths(0, 4, getDeathsForAgeRange(0, 4));
            } else if (age >= 5 && age <= 9) {
                return new AgeBracketDeaths(5, 9, getDeathsForAgeRange(5, 9));
            } else if (age >= 10 && age <= 14) {
                return new AgeBracketDeaths(10, 14, getDeathsForAgeRange(10, 14));
            } else if (age >= 15 && age <= 19) {
                return new AgeBracketDeaths(15, 19, getDeathsForAgeRange(15, 19));
            } else if (age >= 20 && age <= 24) {
                return new AgeBracketDeaths(20, 24, getDeathsForAgeRange(20, 24));
            } else if (age >= 25 && age <= 29) {
                return new AgeBracketDeaths(25, 29, getDeathsForAgeRange(25, 29));
            } else if (age >= 30 && age <= 34) {
                return new AgeBracketDeaths(30, 34, getDeathsForAgeRange(30, 34));
            } else if (age >= 35 && age <= 39) {
                return new AgeBracketDeaths(35, 39, getDeathsForAgeRange(35, 39));
            } else if (age >= 40 && age <= 44) {
                return new AgeBracketDeaths(40, 44, getDeathsForAgeRange(40, 44));
            } else if (age >= 45 && age <= 49) {
                return new AgeBracketDeaths(45, 49, getDeathsForAgeRange(45, 49));
            } else if (age >= 50 && age <= 54) {
                return new AgeBracketDeaths(50, 54, getDeathsForAgeRange(50, 54));
            } else if (age >= 55 && age <= 59) {
                return new AgeBracketDeaths(55, 59, getDeathsForAgeRange(55, 59));
            } else if (age >= 60 && age <= 64) {
                return new AgeBracketDeaths(60, 64, getDeathsForAgeRange(60, 64));
            } else if (age >= 65 && age <= 69) {
                return new AgeBracketDeaths(65, 69, getDeathsForAgeRange(65, 69));
            } else if (age >= 70 && age <= 74) {
                return new AgeBracketDeaths(70, 74, getDeathsForAgeRange(70, 74));
            } else if (age >= 75 && age <= 79) {
                return new AgeBracketDeaths(75, 79, getDeathsForAgeRange(75, 79));
            } else if (age >= 80 && age <= 84) {
                return new AgeBracketDeaths(80, 84, getDeathsForAgeRange(80, 84));
            } else if (age >= 85 && age <= 89) {
                return new AgeBracketDeaths(85, 89, getDeathsForAgeRange(85, 89));
            } else if (age >= 90 && age <= 94){
                return new AgeBracketDeaths(90, 94, getDeathsForAgeRange(90, 94));
            }else{
                return new AgeBracketDeaths(95, 200, getDeathsForAgeRange(95, 200));
            }
    }
}
