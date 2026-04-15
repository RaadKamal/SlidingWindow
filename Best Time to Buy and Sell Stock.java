public class BuyAndSellStock {

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

    public static void main(String[] args) {
        BuyAndSellStock solution = new BuyAndSellStock();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Maximum Profit: " + solution.maxProfit(prices));
    }
}
