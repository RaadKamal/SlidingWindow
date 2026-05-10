public class TrappingRainWater {

    public int trap(int[] height) {
      if (height == null || height.length == 0) {
        return 0;
      }

      int l = 0, r = height.length - 1;
      int leftMax = height[l], rightMax = height[r];
      int total = 0;

      while (l < r) {
       if (leftMax < rightMax) {
         l++;
         leftMax = Math.max(leftMax, height[l]);
         total += leftMax - height[l];
       } else {
         r--;
         rightMax = Math.max(rightMax, height[r]);
         total += rightMax - height[r]; 
       }
      }

      return total;
    }

    public static void main(String[] args) {
     
    }
}
