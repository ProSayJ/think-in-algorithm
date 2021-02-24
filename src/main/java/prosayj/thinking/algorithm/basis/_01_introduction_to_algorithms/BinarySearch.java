package prosayj.thinking.algorithm.basis._01_introduction_to_algorithms;

import prosayj.thinking.algorithm.basis._02_bubble_sort.BubbleSort;
import prosayj.thinking.algorithm.support.BaseTools;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * SelectionSort
 *
 * @author ProSayJ
 * @version V1.0.0
 */
public class BinarySearch {
    /**
     * 二分查找
     *
     * @param srcList
     * @param target
     * @return
     */
    private static Integer binarySearch(Integer[] srcList, int target) {
        if (srcList.length == 0) {
            return null;
        }
        //初始化
        int firstIndex = 0;
        int lastIndex = srcList.length - 1;

        //循环体
        while (firstIndex < lastIndex) {
            int middelIndex = (lastIndex + firstIndex) / 2;
            if (target == srcList[middelIndex]) {
                return middelIndex;
            }
            //说明目标数据target在 (middelIndex,lastIndex]之间
            if (target > srcList[middelIndex]) {
                firstIndex = middelIndex + 1;
            } else {
                //说明目标数据target在 [firstIndex,middelIndex) 之间
                lastIndex = middelIndex;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        List<Integer> integers = BubbleSort.bubbleSort(BaseTools.randomList(15, 10));
        BaseTools.printArray(integers.toArray(new Integer[0]));
        System.out.println(binarySearch(integers.toArray(new Integer[0]), 3));
        System.out.println(binarySearch(integers.toArray(new Integer[0]), 240));
    }
}