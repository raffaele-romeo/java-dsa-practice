package array;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int profit;
        int i = 0;
        int j = 1;

        while (j < prices.length) {
            if (prices[i] < prices[j]) {
                profit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, profit);
                j++;
            } else {
                i = j;
                j = j + 1;
            }
        }

        return maxProfit;
    }
}
