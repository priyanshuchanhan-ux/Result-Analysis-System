
import java.util.*;

class Student {
    int roll, total = 0;
    String name;
    HashMap<String, Integer> marks;

    Student(int r, String n, HashMap<String, Integer> m) {
        roll = r;
        name = n;
        marks = m;

        for (int x : m.values())
            total += x;
    }

    double percentage() {
        return total / 5.0;
    }

    String grade() {
        double p = percentage();
        if (p >= 90) return "A+";
        if (p >= 80) return "A";
        if (p >= 70) return "B";
        if (p >= 60) return "C";
        return "D";
    }
}

public class Main {
    static ArrayList<Student> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n1.Add Student");
            System.out.println("2.Display Results");
            System.out.println("3.Search Student");
            System.out.println("4.Class Ranking");
            System.out.println("5.Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Roll: ");
                    int r = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String n = sc.nextLine();

                    HashMap<String, Integer> m = new HashMap<>();
                    String[] sub = {"Java", "Python", "DSA", "Maths", "DBMS"};

                    for (String s : sub) {
                        System.out.print(s + ": ");
                        int mark = sc.nextInt();
                        if (mark < 0 || mark > 100) {
                            System.out.println("Invalid marks!");
                            m.clear();
                            break;
                        }
                        m.put(s, mark);
                    }

                    if (m.size() == 5) {
                        list.add(new Student(r, n, m));
                        System.out.println("Student Added!");
                    }
                    break;

                case 2:
                    for (Student s : list) {
                        System.out.println(s.roll + " " + s.name
                            + " Total: " + s.total
                            + " Percentage: " + s.percentage()
                            + "% Grade: " + s.grade());
                    }
                    break;

                case 3:
                    System.out.print("Enter Roll: ");
                    int search = sc.nextInt();
                    boolean found = false;

                    for (Student s : list) {
                        if (s.roll == search) {
                            System.out.println("Found: " + s.name);
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Not Found!");
                    break;

                case 4:
                    list.sort((a, b) -> b.total - a.total);
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println((i + 1) + ". "
                            + list.get(i).name + " - "
                            + list.get(i).total);
                    }
                    break;

                case 5:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
