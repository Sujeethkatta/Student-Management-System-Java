import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // Add Student
    public void addStudent(Student student) {
        String query = "INSERT INTO students(name, age, course, email) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, student.getName());
            pst.setInt(2, student.getAge());
            pst.setString(3, student.getCourse());
            pst.setString(4, student.getEmail());

            pst.executeUpdate();
            System.out.println("Student Added Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View All Students
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String query = "SELECT * FROM students";

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("course"),
                        rs.getString("email")
                );
                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Search Student by ID
    public Student getStudentById(int id) {
        String query = "SELECT * FROM students WHERE id=?";
        Student student = null;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                student = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("course"),
                        rs.getString("email")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    // Update Student
    public void updateStudent(Student student) {
        String query = "UPDATE students SET name=?, age=?, course=?, email=? WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, student.getName());
            pst.setInt(2, student.getAge());
            pst.setString(3, student.getCourse());
            pst.setString(4, student.getEmail());
            pst.setInt(5, student.getId());

            pst.executeUpdate();
            System.out.println("Student Updated Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete Student
    public void deleteStudent(int id) {
        String query = "DELETE FROM students WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Student Deleted Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}