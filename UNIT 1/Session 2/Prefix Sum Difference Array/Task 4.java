class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int leftCount = i;
            int leftContribution = x * leftCount - leftSum;


            int rightCount = n - i - 1;
            int rightSum = totalSum - leftSum - x;
            int rightContribution = rightSum - x * rightCount;

            result[i] = leftContribution + rightContribution;
            leftSum += x;
        }

        return result;
    }
}
