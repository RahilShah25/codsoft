import java.util.Scanner;

public class calculateGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of subjects:");
        int numberOfSubjects = scanner.nextInt();

        int totalMarks = 0;
        for (int i = 1; i <= numberOfSubjects; i++) {
            System.out.println("Enter marks obtained in subject " + i + " (out of 100):");
            int marks = scanner.nextInt();
            
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks entered. Marks should be between 0 and 100.");
                return;
            }

            totalMarks += marks;
        }

        double averagePercentage = (double) totalMarks / numberOfSubjects;
        
        String grade = calculateGrad(averagePercentage);

        // Display results
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    private static String calculateGrad(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B";
        } else if (averagePercentage >= 60) {
            return "C";
        } else if (averagePercentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}