import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Course: ");
                    String course = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    dao.addStudent(new Student(name, age, course, email));
                    break;

                case 2:
                    List<Student> students = dao.getAllStudents();
                    for (Student s : students) {
                        System.out.println(s.getId() + " | " + s.getName() + " | " +
                                s.getAge() + " | " + s.getCourse() + " | " + s.getEmail());
                    }
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    Student s = dao.getStudentById(id);
                    if (s != null)
                        System.out.println(s.getName() + " | " + s.getCourse());
                    else
                        System.out.println("Student Not Found!");
                    break;

                case 4:
                    System.out.print("Enter ID to Update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("New Age: ");
                    int newAge = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Course: ");
                    String newCourse = sc.nextLine();

                    System.out.print("New Email: ");
                    String newEmail = sc.nextLine();

                    dao.updateStudent(new Student(uid, newName, newAge, newCourse, newEmail));
                    break;

                case 5:
                    System.out.print("Enter ID to Delete: ");
                    int did = sc.nextInt();
                    dao.deleteStudent(did);
                    break;

                case 6:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}