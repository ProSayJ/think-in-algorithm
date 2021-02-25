package prosayj.thinking.algorithm._03_selection_sort;

import prosayj.thinking.algorithm.support.BaseTools;

import java.util.List;

/**
 * SelectionSort
 *
 * @author ProSayJ
 * @version V1.0.0
 */
public class SelectionSort {

    /**
     * 选择排序：升序排列
     * <p>
     * 线性搜索并找到最小值，将最小值替换最左端的值。依次搜索。
     *
     * @param srcList 原始数组
     * @return 排序后的数组
     */
    private static List<Integer> selectSort(List<Integer> srcList) {
        for (int i = 0; i < srcList.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < srcList.size(); j++) {
                if (srcList.get(j) < srcList.get(minIndex)) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                BaseTools.swapListEle(srcList, i, minIndex);
            }
            System.out.println("====>" + srcList);
        }
        return srcList;
    }

    public static void main(String[] args) {
        List<Integer> srcList = BaseTools.randomList(150, 10);
        System.out.println(srcList);
        List<Integer> selectSort = selectSort(srcList);
        System.out.println(selectSort);
    }

}
