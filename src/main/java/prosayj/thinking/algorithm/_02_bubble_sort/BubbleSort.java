package prosayj.thinking.algorithm._02_bubble_sort;

import prosayj.thinking.algorithm.support.BaseTools;

import java.util.ArrayList;
import java.util.List;

/**
 * 冒泡排序
 * Comparison Sorting Algorithms
 * https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html
 *
 * @author yangjian
 * @link Algorithms.html
 * @since 1.0.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        List<Integer> srcList = BaseTools.randomList(500, 30);
        List<Integer> srcList02 = new ArrayList<>(srcList);
        System.out.println(srcList);


        System.out.println(bubbleSort(srcList));
        System.out.println(bubbleSort2(srcList02));
    }

    /**
     * 冒泡排序：升序排列
     * 遍历元素,两两比较交换获得目标元素
     *
     * @param srcList 原始数组
     * @return 排序后的数组
     */
    public static List<Integer> bubbleSort(List<Integer> srcList) {
        int total = 0;
        for (int i = 0; i < srcList.size() - 1; i++) {
            total++;
            for (int j = 0; j < srcList.size() - 1; j++) {
                if (srcList.get(j) > srcList.get(j + 1)) {
                    BaseTools.swapListEle(srcList, j, j + 1);
                }
                total++;
            }
        }
        System.out.println("==========>" + total);
        return srcList;
    }


    /**
     * 冒泡排序改进:在每一轮排序后记录最后一次元素交换的位置,作为下次比较的边界,
     * 对于边界外的元素在下次循环中无需比较.
     *
     * @param srcList 原始数组
     * @return 排序后的数组
     */
    public static List<Integer> bubbleSort2(List<Integer> srcList) {
        int total = 0;
        // 最后一次交换的位置
        int lastExchange = 0;
        // 无序数据的边界,每次只需要比较到这里即可退出
        int sortBorder = srcList.size() - 1;
        for (int i = 0; i < srcList.size(); i++) {
            total++;
            // 提前退出标志位
            boolean flag = false;
            for (int j = 0; j < sortBorder; j++) {
                if (srcList.get(j) > srcList.get(j + 1)) {
                    BaseTools.swapListEle(srcList, j, j + 1);
                    // 此次冒泡有数据交换
                    flag = true;
                    // 更新最后一次交换的位置
                    lastExchange = j;
                }
                total++;
            }
            sortBorder = lastExchange;
            if (!flag) {
                // 没有数据交换，提前退出
                break;
            }
        }
        System.out.println("==========>" + total);
        return srcList;
    }

}
