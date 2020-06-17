/**
 * 
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 */
public class MedianTwoArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int oddOrEven = (nums1.length + nums2.length) % 2;
        int middleNum = (nums1.length + nums2.length) / 2;
        int[] newArray = new int[nums1.length + nums2.length];
        int j = 0, k = 0, a1 = 0, a2 = 0;
        for (int i = 0; i < newArray.length; i++) {
            //check both arrays for lowest number
            if (j < nums1.length)
                a1 = nums1[j];
            else {
                a1 = a2 + 1;
            }
            if (k < nums2.length)
                a2 = nums2[k];
            else {
                a2 = a1 + 1;
            }
            //insert into new array
            if (a1 <= a2) {
                newArray[i] = a1;
                j++;
            } else {
                newArray[i] = a2;
                k++;
            }
            System.out.print(newArray[i] + "-> ");
        }

        //Find Median
        if (oddOrEven == 1)
            return newArray[middleNum];
        else {
            double median = (double) (newArray[middleNum - 1] + newArray[middleNum]) / 2;
            return median;
        }
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int[] num1 = { 2, 3, 6, 9 };
        int[] num2 = { 1, 7 };

        double median = findMedianSortedArrays(num1, num2);
        System.out.println("Median: " + median);

        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime);
        System.out.println("RunTime: " + totalTime + "ns");
    }
}