// Define the Student class
class Student {
    private String name;
    private int rollNumber;
    private double[] marks;

    public Student(String name, int rollNumber, double[] marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Method to calculate average marks
    public double calculateAverageMarks() {
        double sum = 0;
        for (double mark : marks) {
            sum += mark;
        }
        return sum / marks.length;
    }

    // Method to display student details
    public void displayStudentDetails() {
        System.out.println("Name: " + name + ", Roll Number: " + rollNumber + ", Average Marks: " + calculateAverageMarks());
    }

    // Method to check if the student passed or failed
    public boolean hasPassed(double passingPercentage) {
        return calculateAverageMarks() >= passingPercentage;
    }

    public String getName() {
        return name;
    }
}

// Main class to demonstrate the functionality
public class StudentManagementSystem {
    public static void main(String[] args) {
        // Create an array of Student objects to represent a class
        Student[] students = new Student[3];
        students[0] = new Student("Ali", 101, new double[]{85, 78, 92});
        students[1] = new Student("awais", 102, new double[]{56, 64, 72});
        students[2] = new Student("ahmad", 103, new double[]{90, 91, 89});

        // Display details of all students
        System.out.println("Student details:");
        for (Student student : students) {
            student.displayStudentDetails();
        }

        // Check if each student passed or failed
        double passingPercentage = 60.0;
        System.out.println("\nPass/Fail status:");
        for (Student student : students) {
            if (student.hasPassed(passingPercentage)) {
                System.out.println(student.getName() + " has passed.");
            } else {
                System.out.println(student.getName() + " has failed.");
            }
        }

        // Calculate the class average
        double totalMarks = 0;
        for (Student student : students) {
            totalMarks += student.calculateAverageMarks();
        }
        double classAverage = totalMarks / students.length;
        System.out.println("\nClass average marks: " + classAverage);
    }
}
