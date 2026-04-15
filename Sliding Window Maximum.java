import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Arrays;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        // The output array size is always (length - k + 1)
        int[] output = new int[nums.length - k + 1];
        int outIdx = 0; // Pointer for the output array
        
        // Deque stores indices, not values
        Deque<Integer> q = new ArrayDeque<>();
        int l = 0;
        int r = 0;

        while (r < nums.length) {
            // pop smaller values from q
            // q.peekLast() is the equivalent of q[-1]
            while (!q.isEmpty() && nums[q.peekLast()] < nums[r]) {
                q.pollLast(); // equivalent to q.pop()
            }
            q.offerLast(r); // equivalent to q.append(r)

            // remove left val from window
            // q.peekFirst() is the equivalent of q[0]
            if (l > q.peekFirst()) {
                q.pollFirst(); // equivalent to q.popleft()
            }

            if ((r + 1) >= k) {
                output[outIdx] = nums[q.peekFirst()];
                outIdx++;
                l++;
            }
            r++;
        }

        return output;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = solution.maxSlidingWindow(nums, k);
        System.out.println("Max Sliding Window: " + Arrays.toString(result));
    }
}
