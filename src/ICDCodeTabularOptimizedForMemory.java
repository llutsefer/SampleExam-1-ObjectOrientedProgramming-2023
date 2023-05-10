import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ICDCodeTabularOptimizedForMemory implements ICDCodeTabular{
    @Override
    public  String getDescription(String diseaseCode) throws IndexOutOfBoundsException {
        try {
            Scanner sc = new Scanner(Path.of("data/icd10.txt"));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String icd10Pattern = "\\s[A-Z]\\d{2}(\\.\\d+)*\\s";
                Pattern pattern = Pattern.compile(icd10Pattern);
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String diseaseCodeFromLine = matcher.group().trim();
                    String description = line.split(diseaseCodeFromLine)[1].trim();
                    if(diseaseCodeFromLine.equals(diseaseCode)){
                        sc.close();
                        return description;
                    }
                }
            }
            sc.close();
            throw new IndexOutOfBoundsException();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
