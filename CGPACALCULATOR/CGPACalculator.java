import java.util.Scanner;

public class CGPACalculator {

    static Scanner inp = new Scanner(System.in);

    public static void main(String args[]) {
        System.out.println("Enter the number of semesters:");
        int numSemesters = inp.nextInt();

        double totalCGPA = 0;
        int totalCredits = 0;

        for (int semester = 1; semester <= numSemesters; semester++) {
            System.out.println("Semester " + semester);
            double semesterCGPA = calculateCGPA(semester, numSemesters); 
            totalCGPA += semesterCGPA;
            totalCredits += getTotalCredits(semester);
            System.out.println(); 
        }

        double overallCGPA = totalCGPA / numSemesters;
        System.out.println("Overall CGPA: " + overallCGPA);
    }

    static double calculateCGPA(int semester, int numSemesters) {
        int totalCredits = 0;
        double totalSGPA = 0;

        System.out.println("Enter the number of courses for Semester " + semester + ":");
        int numCourses = inp.nextInt();

        for (int i = 0; i < numCourses; i++) {
            System.out.println("Enter the grade for Course " + (i + 1) + ":");
            String grade = inp.next().toUpperCase(); 
            System.out.println("Enter the course credit for Course " + (i + 1) + ":");
            int courseCredit = inp.nextInt();

            int gradePoint = getGradePoint(grade); 
            double sgpa = calculateSGPA(courseCredit, gradePoint); 
            totalSGPA += sgpa; 
            totalCredits += courseCredit; 
        }

        double semesterSGPA = totalSGPA / totalCredits; 
        System.out.println("Semester SGPA: " + semesterSGPA); 
        return semesterSGPA;
    }

    static int getGradePoint(String grade) {
        switch (grade) {
            case "O":
                return 10;
            case "A+":
                return 9;
            case "A":
                return 8;
            case "B+":
                return 7;
            case "B":
                return 6;
            case "C":
                return 5;
            default:
                return 0; 
        }
    }

    static double calculateSGPA(int courseCredit, int gradePoint) {
        return courseCredit * gradePoint; 
    }

    static int getTotalCredits(int semester) {
        System.out.println("Enter the total credits for Semester " + semester + ":");
        return inp.nextInt();
    }
}