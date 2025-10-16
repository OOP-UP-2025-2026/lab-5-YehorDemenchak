import ua.opnu.Lecturer;
import ua.opnu.Person;
import ua.opnu.Student;
import ua.opnu.TimeSpan;

public class Main {
    public static void main(String[] args) {
        //Завдання 1
        TimeSpan t1 = new TimeSpan();
        TimeSpan t2 = new TimeSpan(45);
        TimeSpan t3 = new TimeSpan(5, 45);
        System.out.println("t1: " + t1.getHours() + " " + t1.getMinutes());
        System.out.println("t2: " + t2.getHours() + " " + t2.getMinutes());
        System.out.println("t3: " + t3.getHours() + " " + t3.getMinutes());

        t1.add(23);
        System.out.println("t1: " + t1.getHours() + " " + t1.getMinutes());
        t1.add(4, 23);
        System.out.println("t1: " + t1.getHours() + " " + t1.getMinutes());
        t1.add(t3);
        System.out.println("t1: " + t1.getHours() + " " + t1.getMinutes());

        t1.subtract(1);
        System.out.println("t1: " + t1.getHours() + " " + t1.getMinutes());
        t1.subtract(1, 2);
        System.out.println("t1: " + t1.getHours() + " " + t1.getMinutes());
        t1.subtract(t2);
        System.out.println("t1: " + t1.getHours() + " " + t1.getMinutes());

        //Завдання 2
        Person person1 = new Person("Семеняко", "Денис", 18);
        Person person2 = new Person("Вараненко", "Віктор", 16);
        Student student1 = new Student("Дегтяренко", "Уляна", 22, "УП-281", 345678);
        Student student2 = new Student("Павлюченко", "Валерія", 20, "УП-281", 345679);
        Student student3 = new Student("Маєр", "Максим", 19, "УП-281", 345679);
        Lecturer lecturer1 = new Lecturer("Хімка", "Богдан", 26, "Кафедра фізики", 20000);
        Lecturer lecturer2 = new Lecturer("Лопез", "Александр", 27, "Кафедра вищої математики та моделювання систем", 21000);

        Person[] arr = new Person[7];
        arr[0] = person1;
        arr[1] = person2;
        arr[2] = student1;
        arr[3] = student2;
        arr[4] = student3;
        arr[5] = lecturer1;
        arr[6] = lecturer2;

        for (Person p : arr) {
            System.out.println(p.toString());
        }
    }
}
