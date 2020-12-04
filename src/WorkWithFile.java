import java.io.*;
import java.util.*;

public class WorkWithFile {

    public static void main(String[] args) {
        String line;
        Scanner scanner;
        HashMap<String, HashMap<String, String>> employees = new HashMap<>();
        List<String> allDateThatHasFile = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/macbookpro/Downloads/ScannerCsvFile/src/acme_worksheet.csv"));
             PrintWriter writer = new PrintWriter(new File("test.csv"))) {
            while ((line = reader.readLine()) != null) {
                scanner = new Scanner(line).useDelimiter(",");
                String nameEmployee = scanner.next();
                if (nameEmployee.intern() != "Employee Name") {
                    if (!employees.containsKey(nameEmployee)) {
                        employees.put(nameEmployee, new HashMap<>());
                    }
                    String worksDay = scanner.next();
                    if (!allDateThatHasFile.contains(worksDay))
                        allDateThatHasFile.add(worksDay);
                    employees.get(nameEmployee).put(worksDay, scanner.next());
                }
            }
            StringBuilder sb = new StringBuilder().append("Name/Date,");
            for (String date : allDateThatHasFile) {
                sb.append(date + ",");
            }
            sb.delete(sb.length() - 1, sb.length());
            for (String i : employees.keySet()) {
                sb.append("\n" + i + ",");
                for (String k : allDateThatHasFile) {
                    sb.append(employees.get(i).getOrDefault(k, "0") + ",");
                }
                sb.delete(sb.length() - 1, sb.length());
            }
            writer.write(sb.toString());
            System.out.println("done!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
