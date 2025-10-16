package ua.opnu;

public class Student extends Person {
    private String group;
    private int studentTicketNumber;

    public Student(String surname, String name, int age, String group, int studentTicketNumber) {
        super(surname, name, age);
        this.group = group;
        this.studentTicketNumber = studentTicketNumber;
    }

    @Override
    public String toString() {
        return "Студент групи " + group + ", " + getSurname() + " " + getName() + ", вік: " + getAge() + ".Номер студентського квитка: " + studentTicketNumber;
    }

    public String getGroup() {
        return group;
    }

    public int getStudentTicketNumber() {
        return studentTicketNumber;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setStudentTicketNumber(int studentTicketNumber) {
        this.studentTicketNumber = studentTicketNumber;
    }
}
