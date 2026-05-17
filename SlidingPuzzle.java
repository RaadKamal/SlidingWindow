import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Deque;
import java.util.HashSet;

public class SlidingPuzzle {


    private static class State {
        int i;
        String b;
        int length;

        State(int i, String b, int length) {
            this.i = i;
            this.b = b;
            this.length = length;
        }
    }

    Set<State> set = new HashSet<>();
    List<State> list = new ArrayList<>();

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
        set.add(new State(seen.indexOf('0'), seen, 0));
    }

    

    
    public static void main(String[] args) {

    }
}
