package prosayj.thinking.algorithm.basis._02_bubble_sort;

import prosayj.thinking.algorithm.BaseTools;

import java.util.List;

/**
 * 冒泡排序
 * Comparison Sorting Algorithms
 * https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html
 *
 * @author yangjian
 * @date 2021-02-20 下午 03:51
 * @since 1.0.0
 */
public class BubbleSort {

    /**
     * 冒泡排序：升序排列
     * 遍历元素,两两比较交换获得目标元素
     *
     * @param srcList 原始数组
     * @return 排序后的数组
     */
    private static List<Integer> bubbleSort(List<Integer> srcList) {
        for (int i = 0; i < srcList.size() - 1; i++) {
            Integer minValue = srcList.get(i);
            for (int j = i + 1; j < srcList.size(); j++) {
                if (minValue > srcList.get(j)) {
                    BaseTools.swapListEle(srcList, i, j);
                }
            }
            System.out.println("====>" + srcList);
        }
        return srcList;
    }

    public static void main(String[] args) {
        List<Integer> srcList = BaseTools.randomList(150, 10);
        System.out.println(srcList);
        List<Integer> selectSort = bubbleSort(srcList);
        System.out.println(selectSort);
    }
}
