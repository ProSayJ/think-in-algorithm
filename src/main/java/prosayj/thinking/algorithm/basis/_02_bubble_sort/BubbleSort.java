package prosayj.thinking.algorithm.basis._02_bubble_sort;

import prosayj.thinking.algorithm.support.BaseTools;

import java.util.List;

/**
 * 冒泡排序
 * Comparison Sorting Algorithms
 * https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html
 *
 * @author yangjian
 * @since 1.0.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        List<Integer> srcList = BaseTools.randomList(500, 10);
        System.out.println(srcList);
        List<Integer> selectSort = bubbleSort(srcList);
        System.out.println(selectSort);
    }

    /**
     * 冒泡排序：升序排列
     * 遍历元素,两两比较交换获得目标元素
     *
     * @param srcList 原始数组
     * @return 排序后的数组
     */
    public static List<Integer> bubbleSort(List<Integer> srcList) {
        for (int i = 0; i < srcList.size() - 1; i++) {
            for (int j = 0; j < srcList.size() - 1; j++) {
                if (srcList.get(j) > srcList.get(j + 1)) {
                    BaseTools.swapListEle(srcList, j, j + 1);
                }
            }
            //System.out.println("====>" + srcList);
        }
        return srcList;
    }

}
