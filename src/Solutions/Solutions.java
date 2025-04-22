package Solutions;

import java.util.*;

public class Solutions
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter the desired ruler length (X)
        System.out.println("Enter the integer length of the ruler (X): ");
        int rulerLength = scanner.nextInt();

        // Calculate the fewest marks needed to measure all lengths from 1 to X
        ArrayList<Integer> marks = findFewestMarks(rulerLength);

        // Display results
        System.out.println("Fewest marks needed: " + marks.size());
        System.out.println("Marks on the ruler: " + marks);
    }

    // Finds the fewest number of marks that can measure all distances from 1 to length
    public static ArrayList<Integer> findFewestMarks(int length)
    {
        // Try increasing number of marks until a valid solution is found
        for (int markCount = 2; markCount <= length + 1; markCount++)
        {
            ArrayList<Integer> result = backtrackRuler(length, markCount);
            if (result != null)
            {
                return result;
            }
        }

        // Fallback (should not happen for reasonable input)
        return new ArrayList<>();
    }

    // Starts the backtracking with initial mark at 0
    public static ArrayList<Integer> backtrackRuler(int maxLength, int numMarks)
    {
        ArrayList<Integer> currentMarks = new ArrayList<>();
        currentMarks.add(0); // Always include 0 at the start
        return backtrack(1, maxLength, numMarks, currentMarks);
    }

    // Recursive backtracking method to generate valid mark combinations
    public static ArrayList<Integer> backtrack(int nextStart, int maxLength, int numMarks, ArrayList<Integer> currentMarks)
    {
        // Base case: if we have the required number of marks, check if it's valid
        if (currentMarks.size() == numMarks)
        {
            if (canMeasureAll(currentMarks, maxLength))
            {
                return new ArrayList<>(currentMarks);
            }
            return null;
        }

        // Try placing the next mark from 'nextStart' up to maxLength
        for (int i = nextStart; i <= maxLength; i++)
        {
            currentMarks.add(i);

            ArrayList<Integer> result = backtrack(i + 1, maxLength, numMarks, currentMarks);
            if (result != null)
            {
                return result;
            }

            // Backtrack
            currentMarks.remove(currentMarks.size() - 1);
        }

        return null;
    }

    // Checks if all integer distances from 1 to maxLength can be measured
    public static boolean canMeasureAll(ArrayList<Integer> marks, int maxLength)
    {
        HashSet<Integer> diffs = new HashSet<>();

        // Collect all pairwise distances
        for (int i = 0; i < marks.size(); i++)
        {
            for (int j = i + 1; j < marks.size(); j++)
            {
                diffs.add(Math.abs(marks.get(j) - marks.get(i)));
            }
        }

        // Ensure we can measure every integer from 1 to maxLength
        for (int i = 1; i <= maxLength; i++)
        {
            if (!diffs.contains(i))
            {
                return false;
            }
        }

        return true;
    }
}
