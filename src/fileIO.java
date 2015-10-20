import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class fileIO {

  List<String> male = new ArrayList<>();
  List<String> female = new ArrayList<>();
  List<String> surnames = new ArrayList<>();

  public List<String> male() throws IOException {

    BufferedReader reader = new BufferedReader(new FileReader("namesource/rus_male_names.txt"));
    String line;
    while ((line = reader.readLine()) != null) {
      male.add(line);
    }
    return male;
  }
  public List<String> female() throws IOException {

    BufferedReader reader = new BufferedReader(new FileReader("namesource/rus_female_names.txt"));
    String line;
    while ((line = reader.readLine()) != null) {
      female.add(line);
    }
    return female;
  }
  public List<String> surnames() throws IOException {

    BufferedReader reader = new BufferedReader(new FileReader("namesource/surnames.txt"));
    String line;
    while ((line = reader.readLine()) != null) {
      surnames.add(line);
    }
    return surnames;
  }

}
