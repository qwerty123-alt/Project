import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        // уник
        Institution institution = new Institution("Astana IT University", "Mangilik El, C1.4");

        // студенты
        Student student1 = new Student(1, "Kanat Kanatov", 19, "A", "kanatkanatov@gmail.com");
        Student student2 = new Student(2, "Dauren Nagumash", 17, "D", "nahumsw228@gmail.com");
        institution.addStudent(student1);
        institution.addStudent(student2);

        // Добавляем преподавателей
        Teacher teacher1 = new Teacher(1, "Orazova Arailym", "Object-Oriented Programming", 10, "orazovaaarailym@gmail.com");
        Teacher teacher2 = new Teacher(2, "Raikhan Madi", "Calculus", 8, "raikhanmadi@gmail.com");
        institution.addTeacher(teacher1);
        institution.addTeacher(teacher2);

        // Выводим информацию
        institution.getSummary();
    }
}

class Student {
    private int id;
    private String name;
    private int age;
    private String grade;
    private String email;

    public Student(int id, String name, int age, String grade, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.email = email;
    }

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

class Teacher {
    private int id;
    private String name;
    private String subject;
    private int experience;
    private String email;

    public Teacher(int id, String name, String subject, int experience, String email) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.experience = experience;
        this.email = email;
    }

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

class Institution {
    private String name;
    private String location;
    private List<Student> students;
    private List<Teacher> teachers;

    public Institution(String name, String location) {
        this.name = name;
        this.location = location;
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void getSummary() {
        System.out.println("University: " + name);
        System.out.println("Location: " + location);
        System.out.println("\nStudents:");
        for (Student student : students) {
            System.out.println("- " + student.getName() + " (Grade: " + student.getGrade() + ")");
        }

        System.out.println("\nTeachers:");
        for (Teacher teacher : teachers) {
            System.out.println("- " + teacher.getName() + " (Subject: " + teacher.getSubject() + ")");
        }
    }
}