import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Создаем уник
        Institution institution = new Institution("Astana IT University", "Mangilik El, C1.4");

        // Добавляем студентовч
        Student student1 = new Student(1, "Kanat Kanatov", 19, "A", "kanatkanatov@gmail.com");
        Student student2 = new Student(2, "Dauren Nagumash", 17, "D", "nahumsw228@gmail.com");
        institution.addStudent(student1);
        institution.addStudent(student2);

        // Добавляем преподавателей
        Teacher teacher1 = new Teacher(1, "Orazova Arailym", "Object-Oriented Programming", 10, "orazovaaarailym@gmail.com");
        Teacher teacher2 = new Teacher(2, "Raikhan Madi", "Calculus", 8, "raikhanmadi@gmail.com");
        institution.addTeacher(teacher1);
        institution.addTeacher(teacher2);

        // Выводим сводку
        institution.getSummary();

        // Пример фильтрации студентов по оценке
        System.out.println("\nStudents with grade A:");
        List<Student> filteredStudents = institution.filterStudentsByGrade("A");
        filteredStudents.forEach(System.out::println);

        // Пример сортировки преподавателей по опыту
        System.out.println("\nTeachers sorted by experience:");
        List<Teacher> sortedTeachers = institution.sortTeachersByExperience();
        sortedTeachers.forEach(System.out::println);
    }
}

class Person {
    private int id;
    private String name;
    private String email;

    public Person(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Person{id=" + id + ", name='" + name + "', email='" + email + "'}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return id == person.id && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

class Student extends Person {
    private int age;
    private String grade;

    public Student(int id, String name, int age, String grade, String email) {
        super(id, name, email);
        this.age = age;
        this.grade = grade;
    }

    public int getAge() {
        return age;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{id=" + getId() + ", name='" + getName() + "', age=" + age +
                ", grade='" + grade + "', email='" + getEmail() + "'}";
    }
}

class Teacher extends Person {
    private String subject;
    private int experience;

    public Teacher(int id, String name, String subject, int experience, String email) {
        super(id, name, email);
        this.subject = subject;
        this.experience = experience;
    }

    public String getSubject() {
        return subject;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return "Teacher{id=" + getId() + ", name='" + getName() + "', subject='" +
                subject + "', experience=" + experience + " years, email='" + getEmail() + "'}";
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

    public List<Student> filterStudentsByGrade(String grade) {
        return students.stream()
                .filter(student -> student.getGrade().equalsIgnoreCase(grade))
                .collect(Collectors.toList());
    }

    public List<Teacher> sortTeachersByExperience() {
        return teachers.stream()
                .sorted(Comparator.comparingInt(Teacher::getExperience).reversed())
                .collect(Collectors.toList());
    }

    public void getSummary() {
        System.out.println("Institution: " + name);
        System.out.println("Location: " + location);

        System.out.println("\nStudents:");
        students.forEach(System.out::println);

        System.out.println("\nTeachers:");
        teachers.forEach(System.out::println);
    }
}