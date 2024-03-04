package hw.sem4;

import java.util.ArrayList;
import java.util.List;

public class EmployeesMethods {

    private List<Employees> employees;

    public EmployeesMethods() {
        employees = new ArrayList<>();
    }

    public List<Employees> findByExper(int exper) {
        List<Employees> foundByExper = new ArrayList<>();
        for (Employees empl : employees) {
            if (empl.getExp() == exper) {
                System.out.println("Found by experience:\n" + empl + "\n");
                foundByExper.add(empl);
            }
        }
        return foundByExper;
    }

    public int getNumberByName(String name) {
        for (Employees empl : employees) {
            if (name.equals(empl.getName())) {
                System.out.println("Employee by name: " + empl + "\n");
                return empl.getPhoneNumber();
            }
        }
        return -1;
    }

    public Employees findByPersNumber(int persNumber) {

        for (Employees empl : employees) {
            if (persNumber == empl.getPersNumber()) {
                System.out.println
                        ("Found employee by personal number: \n" + empl + "\n");
                return empl;
            }
        }
        return null;
    }

    public void addNew(Employees employee) {
        employees.add(employee);
    }
}
