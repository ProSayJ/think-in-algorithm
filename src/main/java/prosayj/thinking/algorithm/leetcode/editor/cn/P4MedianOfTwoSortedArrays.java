//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
// Related Topics 数组 二分查找 分治算法 
// 👍 3707 👎 0

package prosayj.thinking.algorithm.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 寻找两个正序数组的中位数
 * <p>给定两个大小为 m 和 n 的正序（从小到大）数组&nbsp;<code>nums1</code> 和&nbsp;<code>nums2</code>。请你找出并返回这两个正序数组的中位数。</p>
 *
 * <p><strong>进阶：</strong>你能设计一个时间复杂度为 <code>O(log (m+n))</code> 的算法解决此问题吗？</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>nums1 = [1,3], nums2 = [2]
 * <strong>输出：</strong>2.00000
 * <strong>解释：</strong>合并数组 = [1,2,3] ，中位数 2
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>nums1 = [1,2], nums2 = [3,4]
 * <strong>输出：</strong>2.50000
 * <strong>解释：</strong>合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre><strong>输入：</strong>nums1 = [0,0], nums2 = [0,0]
 * <strong>输出：</strong>0.00000
 * </pre>
 *
 * <p><strong>示例 4：</strong></p>
 *
 * <pre><strong>输入：</strong>nums1 = [], nums2 = [1]
 * <strong>输出：</strong>1.00000
 * </pre>
 *
 * <p><strong>示例 5：</strong></p>
 *
 * <pre><strong>输入：</strong>nums1 = [2], nums2 = []
 * <strong>输出：</strong>2.00000
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>nums1.length == m</code></li>
 * 	<li><code>nums2.length == n</code></li>
 * 	<li><code>0 &lt;= m &lt;= 1000</code></li>
 * 	<li><code>0 &lt;= n &lt;= 1000</code></li>
 * 	<li><code>1 &lt;= m + n &lt;= 2000</code></li>
 * 	<li><code>-10<sup>6</sup> &lt;= nums1[i], nums2[i] &lt;= 10<sup>6</sup></code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>二分查找</li><li>分治算法</li></div></div>\n<div><li>👍 3707</li><li>👎 0</li></div>
 */
public class P4MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new P4MedianOfTwoSortedArrays().new Solution();
        // TO TEST
        System.out.println(
                solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//            int num1Max = nums1[nums1.length - 1];
//            int num2Max = nums1[nums2.length - 1];
//            //从0开始
//            int totalNumIndex = nums1.length - 1 + nums2.length;
//            int startIndex = -1;
//            int endIndex = -1;
//
//
//            if (totalNumIndex % 2 == 0) {
//                //偶数中位数位置： n/2 和 n+2/2
//                startIndex = totalNumIndex / 2;
//                endIndex = (totalNumIndex + 1) / 2;
//
//            } else {
//                //奇数中位数位置： n+1/2
//            }
//            return 0d;
            return m2(nums1, nums2);
        }

        private double m2(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            int left = (m + n + 1) / 2;
            int right = (m + n + 2) / 2;
            return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
        }

        //i: nums1的起始位置 j: nums2的起始位置
        private int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
            if (i >= nums1.length) {
                //nums1为空数组
                return nums2[j + k - 1];
            }
            if (j >= nums2.length) {
                //nums2为空数组
                return nums1[i + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[i], nums2[j]);
            }
            int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
            int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
            if (midVal1 < midVal2) {
                return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
            } else {
                return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}