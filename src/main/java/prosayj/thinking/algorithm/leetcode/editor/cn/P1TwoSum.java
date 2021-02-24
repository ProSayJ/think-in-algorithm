//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 103 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 只会存在一个有效答案 
// 
// Related Topics 数组 哈希表 
// 👍 10312 👎 0

package prosayj.thinking.algorithm.leetcode.editor.cn;

import prosayj.thinking.algorithm.support.BaseTools;

/**
 * 两数之和:
 * <p>给定一个整数数组 <code>nums</code> 和一个整数目标值 <code>target</code>，请你在该数组中找出 <strong>和为目标值</strong> 的那 <strong>两个</strong> 整数，并返回它们的数组下标。</p>
 *
 * <p>你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。</p>
 *
 * <p>你可以按任意顺序返回答案。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [2,7,11,15], target = 9
 * <strong>输出：</strong>[0,1]
 * <strong>解释：</strong>因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [3,2,4], target = 6
 * <strong>输出：</strong>[1,2]
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [3,3], target = 6
 * <strong>输出：</strong>[0,1]
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>2 <= nums.length <= 10<sup>3</sup></code></li>
 * 	<li><code>-10<sup>9</sup> <= nums[i] <= 10<sup>9</sup></code></li>
 * 	<li><code>-10<sup>9</sup> <= target <= 10<sup>9</sup></code></li>
 * 	<li><strong>只会存在一个有效答案</strong></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>哈希表</li></div></div>\n<div><li>👍 10312</li><li>👎 0</li></div>
 */
public class P1TwoSum {
    public static void main(String[] args) {
        Solution solution = new P1TwoSum().new Solution();
        // TO TEST
        BaseTools.printArray(solution.twoSum(new int[]{2, 7, 11, 15, 10}, 17));
        BaseTools.printArray(solution.twoSum(new int[]{3, 3}, 6));
        BaseTools.printArray(solution.twoSum(new int[]{1, 2, 4}, 6));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            return method1(nums, target);
        }

        /**
         * 第一种解法: 内存消耗少，耗时长
         * 内存消耗:38.6 MB
         * 执行耗时:11 ms ~ 18 ms
         */
        private int[] method1(int[] nums, int target) {
            int[] result = new int[2];
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if ((target - nums[i]) == nums[j]) {
                        result[0] = i;
                        result[1] = j;
                        break;
                    }
                }
            }
            return result;
        }

        /**
         * 第二种解法
         */
        private int[] method2(int[] nums, int target) {
            int[] result = new int[2];
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if ((target - nums[i]) == nums[j]) {
                        result[0] = i;
                        result[1] = j;
                        break;
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}