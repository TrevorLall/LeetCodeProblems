/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container and n is at least 2.
 * 
 * Example: Input: [1,8,6,2,5,4,8,3,7] -> Output: 49
 * 
 * End Result: I could have optimized the algorithm a lot better by instead
 * using the brute force approach, I could have done it in a single pass, by
 * starting from both ends and calculating the current max between them. Then
 * keep moving one step closer until both endpoints meet.
 */

public class WaterContainer {
    public static int maxArea(int[] height) {
        int currentMax = 0;

        // Check if n is at least 2
        if (height.length < 2)
            return 0;

        // Loop Through array
        for (int i = 0; i < height.length; i++) {
            // inner loop, find current maxarea
            for (int j = 0; j < height.length; j++) {
                if (i != j) {
                    int rectWidth = Math.abs(j - i);
                    int rectHeight = Math.min(height[i], height[j]);
                    int area = rectHeight * rectWidth;
                    if (area > currentMax)
                        currentMax = area;
                    System.out.println("[" + height[i] + "," + height[j] + "] " + "RectWidth: " + rectWidth
                            + " rectHeight: " + rectHeight + " Area: " + area);
                }
            }
        }

        // return max area
        return currentMax;
    }

    /*Site Solution
    public int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
    */

    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        int area = maxArea(height);
        System.out.print(area);
    }
}