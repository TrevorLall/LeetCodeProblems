import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * -----------------------------------------------------------------------------------------------------
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * Result: I tried to get it done in O(n), but in reality it had to be done in O(n2)
 *         I needed an outer loop to cycle through each item in the array i times.
 *
 */
public class SumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        //Sort the array
        Arrays.sort(nums);

        //Keep track of the high and low
        int high = (nums.length - 1), low = 0, closest = 4000, curr = 0;
        //loop through the array
        while (low < high && low + 1 != high) {
            int numCheck = nums[high] + nums[low] + nums[low + 1];
            int distance = Math.abs(numCheck - target);
            if (distance < closest) {
                closest = distance;
                curr = numCheck;
                System.out.println(nums[low] + " + " + nums[high] + " + " + nums[low + 1]);
            }
            if (numCheck < target) {
                low++;
            } else if (numCheck > target) {
                high--;
            } else {
                return numCheck;
            }
        }
        //compare to the target
        return curr;
    }

    public static void main(String[] args) {
        int[] nums = { -1, 2, 1, -4, 7, -9, 10, 12 };
        int target = 1;
        int output = threeSumClosest(nums, target);
        System.out.println("Output: " + output);
    }
}