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
        if (age >= 0 && age <= 4) {
            return new AgeBracketDeaths(0, 4, DeathCauseStatisticList.getDeathFromAge(age));
        } else if (age >= 5 && age <= 9) {
            return new AgeBracketDeaths(5, 9, DeathCauseStatisticList.getDeathFromAge(age));
        } else if (age >= 10 && age <= 14) {
            return new AgeBracketDeaths(10, 14, DeathCauseStatisticList.getDeathFromAge(age));
        } else if (age >= 15 && age <= 19) {
            return new AgeBracketDeaths(15, 19, DeathCauseStatisticList.getDeathFromAge(age));
        } else if (age >= 20 && age <= 24) {
            return new AgeBracketDeaths(20, 24, DeathCauseStatisticList.getDeathFromAge(age));
        } else if (age >= 25 && age <= 29) {
            return new AgeBracketDeaths(25, 29, DeathCauseStatisticList.getDeathFromAge(age));
        } else if (age >= 30 && age <= 34) {
            return new AgeBracketDeaths(30, 34, DeathCauseStatisticList.getDeathFromAge(age));
        } else if (age >= 35 && age <= 39) {
            return new AgeBracketDeaths(35, 39, DeathCauseStatisticList.getDeathFromAge(age));
        } else if (age >= 40 && age <= 44) {
            return new AgeBracketDeaths(40, 44, DeathCauseStatisticList.getDeathFromAge(age));
        } else if (age >= 45 && age <= 49) {
            return new AgeBracketDeaths(45, 49, DeathCauseStatisticList.getDeathFromAge(age));
        } else if (age >= 50 && age <= 54) {
            return new AgeBracketDeaths(50, 54, DeathCauseStatisticList.getDeathFromAge(age));
        } else if (age >= 55 && age <= 59) {
            return new AgeBracketDeaths(55, 59, DeathCauseStatisticList.getDeathFromAge(age));
        } else if (age >= 60 && age <= 64) {
            return new AgeBracketDeaths(60, 64, DeathCauseStatisticList.getDeathFromAge(age));
        } else if (age >= 65 && age <= 69) {
            return new AgeBracketDeaths(65, 69, DeathCauseStatisticList.getDeathFromAge(age));
        } else if (age >= 70 && age <= 74) {
            return new AgeBracketDeaths(70, 74, DeathCauseStatisticList.getDeathFromAge(age));
        } else if (age >= 75 && age <= 79) {
            return new AgeBracketDeaths(75, 79, DeathCauseStatisticList.getDeathFromAge(age));
        } else if (age >= 80 && age <= 84) {
            return new AgeBracketDeaths(80, 84, DeathCauseStatisticList.getDeathFromAge(age));
        } else if (age >= 85 && age <= 89) {
            return new AgeBracketDeaths(85, 89, DeathCauseStatisticList.getDeathFromAge(age));
        } else if (age >= 90 && age <= 94) {
            return new AgeBracketDeaths(90, 94, DeathCauseStatisticList.getDeathFromAge(age));
        } else {
            return new AgeBracketDeaths(95, 200, DeathCauseStatisticList.getDeathFromAge(age));
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
