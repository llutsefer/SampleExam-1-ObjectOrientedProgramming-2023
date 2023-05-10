import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ICDCodeTabularOptimizedForTime implements ICDCodeTabular{

    public static Map<String, String> diseaseCodeWithDescription = new HashMap<>();

    public ICDCodeTabularOptimizedForTime() {
        try {
            Scanner sc = new Scanner(Path.of("data/icd10.txt"));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String icd10Pattern = "\\s[A-Z]\\d{2}(\\.\\d+)*\\s";
                Pattern pattern = Pattern.compile(icd10Pattern);
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String diseaseCode = matcher.group().trim();
                    String description = line.split(diseaseCode)[1].trim();
                    diseaseCodeWithDescription.put(diseaseCode, description);
                }
            }
            sc.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getDescription(String diseaseCode) throws IndexOutOfBoundsException {
        if(diseaseCodeWithDescription.containsKey(diseaseCode)){
            return diseaseCodeWithDescription.get(diseaseCode);
        }
        else{
            throw new IndexOutOfBoundsException();
        }
    }


}
