package prosayj.thinking.algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 辅助算法操作的基础工具类
 *
 * @author yangjian@bubi.cn
 * @date 2020-05-03 下午 05:50
 * @since 1.0.0
 */
public class BaseTools {
    /**
     * 打印数组
     *
     * @param arr 待打印的数组
     */
    public static void printArray(int[] arr) {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                result.append(arr[i]).append(", ");
            } else {
                result.append(arr[i]).append("]");
            }
        }
        System.out.println(result.toString());
    }


    /**
     * 交换数组中指定位置的数据
     *
     * @param nums   数组
     * @param index1 索引位置
     * @param index2 索引位置
     */
    public static void swapArrEle(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    /**
     * 交换数组中指定位置的数据
     *
     * @param srcList 数组
     * @param index1  索引位置
     * @param index2  索引位置
     */
    public static void swapListEle(List<Integer> srcList, int index1, int index2) {
        int temp = srcList.get(index1);
        srcList.set(index1, srcList.get(index2));
        srcList.set(index2, temp);
    }

    /**
     * 生成随机的数组
     *
     * @param maxNum    数组的最大值
     * @param arraySize 数组大小
     * @return 目标数组arr
     */
    public static Integer[] randomArray(int maxNum, int arraySize) {
        Integer[] nums = new Integer[arraySize];
        for (int i = 0; i < arraySize; i++) {
            nums[i] = new Random().nextInt(maxNum + 1);
        }
        return nums;
    }

    /**
     * 生成随机的数组
     *
     * @param maxNum    数组的最大值
     * @param arraySize 数组大小
     * @return 目标数组arr
     */
    public static List<Integer> randomList(int maxNum, int arraySize) {
        Integer[] randomArrays = randomArray(maxNum, arraySize);
        return Arrays.asList(randomArrays);
    }


}
