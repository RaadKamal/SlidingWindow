import java.util.ArrayList;
import java.util.List;

public class SlidingPuzzle {

    private static final int[][] ADJACENT = {
        {1, 3},    // neighbors for index 0
        {0, 2, 4}, // neighbors for index 1
        {1, 5},    // neighbors for index 2
        {0, 4},    // neighbors for index 3
        {1, 3, 5}, // neighbors for index 4
        {2, 4}     // neighbors for index 5
    };

    String seen = new String();
    // Constructor to initialize seen from a given board
    public SlidingPuzzle(int[][] board) {
        for (int[] row : board) {
            for (int c : row) {
                
                seen += String.valueOf(c);
            }
        }
    }

    
    public static void main(String[] args) {

    }
}
