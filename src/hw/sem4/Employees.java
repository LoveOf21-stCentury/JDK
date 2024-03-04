package hw.sem4;

public class Employees {
    private int persNumber;
    private int phoneNumber;
    private String name;
    private int exp;

    public Employees(int persNumber, int phoneNumber, String name, int exp) {
        this.persNumber = persNumber;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.exp = exp;
    }

    public int getPersNumber() {
        return persNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getExp() {
        return exp;
    }

    @Override
    public String toString() {
        return name + "\n" +
                "personal number: " + persNumber + "\n" +
                "phone number: " + phoneNumber + "\n" +
                "experience in company: " + exp;
    }
}
