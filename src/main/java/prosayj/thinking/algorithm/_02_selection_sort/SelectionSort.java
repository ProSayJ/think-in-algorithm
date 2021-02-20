package prosayj.thinking.algorithm._02_selection_sort;

import java.util.Arrays;
import java.util.List;

/**
 * SelectionSort
 *
 * @author ProSayJ
 * @version V1.0.0
 */
public class SelectionSort {

    /**
     * 选择排序：降序排列
     *
     * @param srcList 原始数组
     * @return 排序后的数组
     */
    public static List<Integer> selectSort(List<Integer> srcList) {
        int index = 0;
        for (int i = 0; i < srcList.size() - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < srcList.size(); j++) {
                if (srcList.get(j) > srcList.get(maxIndex)) {
                    maxIndex = j;
                }
            }
            int temp = srcList.get(i);
            srcList.set(i, srcList.get(maxIndex));
            srcList.set(maxIndex, temp);
        }
        return srcList;
    }

    public static void main(String[] args) {
        List<Integer> selectSort = selectSort(Arrays.asList(5, 3, 6, 2, 10));
        System.out.println(selectSort);
    }

}
