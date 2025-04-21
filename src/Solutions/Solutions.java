package Solutions;

import java.util.ArrayList;
import java.util.Scanner;

public class Solutions
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the ruler length
        System.out.println("Enter the integer length of the ruler (X): ");
        int rulerLength = scanner.nextInt();

        // Calculate and display the marks needed on the ruler
        ArrayList<Integer> marks = calculateMarks(rulerLength);
        System.out.println("Fewest marks needed: " + marks.size());
        System.out.println("Marks on the ruler: " + marks);
    }

    // Method to calculate the fewest marks needed on the ruler
    public static ArrayList<Integer> calculateMarks(int length)
    {
        ArrayList<Integer> marks = new ArrayList<>();

        // Always start with the first mark at 0
        marks.add(0);

        // Place marks following the Golomb ruler principle
        for (int i = 1; i <= length ; i++)
        {
            boolean isValidMark = true;

            // Check if placing a mark at position i avoids repetition of differences
            for (int mark : marks)
            {
                if (marks.contains(i - mark + 1))
                {
                    isValidMark = false;
                    break;
                }
            }

            if (isValidMark)
            {
                marks.add(i);
            }
        }

        return marks;
    }
}
