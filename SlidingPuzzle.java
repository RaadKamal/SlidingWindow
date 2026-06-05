import java.util.LinkedList;
import java.util.Queue;
import java.util.HashSet;
import java.util.Set;

public class SlidingPuzzle {
    
    // Encapsulates the traversal state to maintain structural integrity within the queue.
    private static class State {
        int zeroIndex;
        String board;
        int moves;

        State(int zeroIndex, String board, int moves) {
            this.zeroIndex = zeroIndex;
            this.board = board;
            this.moves = moves;
        }
    }

    public int slidingPuzzle(int[][] board) {
        // Defines the valid transposition indices for the '0' tile in a flattened 1D array.
        int[][] adj = {
            {1, 3},       // Index 0 can move to 1 or 3
            {0, 2, 4},    // Index 1 can move to 0, 2, or 4
            {1, 5},       // Index 2 can move to 1 or 5
            {0, 4},       // Index 3 can move to 0 or 4
            {1, 3, 5},    // Index 4 can move to 1, 3, or 5
            {2, 4}        // Index 5 can move to 2 or 4
        };

        // Linearise the 2D board into a 1D String representation.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }
        
        String startState = sb.toString();
        int startIndex = startState.indexOf('0');

        // Initialise the Breadth-First Search queue and visited set.
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(startIndex, startState, 0));

        Set<String> visited = new HashSet<>();
        visited.add(startState);

        final String target = "123450";

        // Commence the systematic exploration of board configurations.
        while (!queue.isEmpty()) {
            State current = queue.poll();

            // Termination condition: The target configuration has been achieved.
            if (current.board.equals(target)) {
                return current.moves;
            }

            // Iterate over all permissible moves for the '0' tile from its current position.
            for (int nextIndex : adj[current.zeroIndex]) {
                char[] chars = current.board.toCharArray();
                
                // Execute the transposition (swapping '0' with the adjacent tile).
                char temp = chars[current.zeroIndex];
                chars[current.zeroIndex] = chars[nextIndex];
                chars[nextIndex] = temp;

                String nextState = new String(chars);

                // If this constitutes a novel configuration, append it to the queue.
                if (!visited.contains(nextState)) {
                    visited.add(nextState);
                    queue.offer(new State(nextIndex, nextState, current.moves + 1));
                }
            }
        }

        // Return -1 if the queue is exhausted without encountering the target state.
        return -1;
    }
}