import java.io.*;
import java.util.*;

public class WorkWithFile {

    public static void main(String[] args) {
        String line;
        Scanner scanner;
        Employee emp;
        HashMap<String, Employee> employees = new HashMap<>();
        List<String> allDate = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/macbookpro/Downloads/ScannerCsvFile/src/acme_worksheet.csv"));
             PrintWriter writer = new PrintWriter(new File("test.csv"))) {
            while ((line = reader.readLine()) != null) {
                scanner = new Scanner(line).useDelimiter(",");
                String nameEmployee = scanner.next();
                if (nameEmployee.intern() != "Employee Name") {
                    if (!employees.containsKey(nameEmployee)) {
                        employees.put(nameEmployee, emp = new Employee());
                    }
                    String worksDay = scanner.next();
                    if (!allDate.contains(worksDay))
                        allDate.add(worksDay);
                    employees.get(nameEmployee).getDateWithHours().put(worksDay, scanner.next());
                }
            }
            StringBuilder sb = new StringBuilder().append("Name/Date,");
            for (String date : allDate) {
                sb.append(date + ",");
            }
            sb.delete(sb.length() - 1, sb.length());
            for (String i : employees.keySet()) {
                sb.append("\n" + i + ",");
                for (String k : allDate) {
                    emp = employees.get(i);
                    sb.append(emp.getDateWithHours().getOrDefault(k, "0") + ",");
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
