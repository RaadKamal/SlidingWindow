import java.util.HashSet;
import java.util.Set;
import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindow {

    private boolean Dup(int[] num, int k) {
        Set<Integer> duplicate = new HashSet<>();
        int L = 0;

        for (int R = 0; R < num.length; R++) {
            if (R - L > k) {
                duplicate.remove(num[L]);
                L += 1; // or L++
            }
            if (duplicate.contains(num[R])) {
                return true;
            }
            duplicate.add(num[R]);
        }

        return false;
    }

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

    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 1;
        int maxP = 0;

        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                int profit = prices[r] - prices[l];
                maxP = Math.max(maxP, profit);
            } else {
                l = r;
            }
            r++; // equivalent to r += 1
        }

        return maxP;
    }
}

    

