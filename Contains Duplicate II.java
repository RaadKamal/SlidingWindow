import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public boolean Dup(int[] num, int k) {
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

    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println("Contains Duplicate: " + solution.Dup(nums, k));
    }
}
