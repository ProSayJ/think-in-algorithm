package prosayj.thinking.algorithm.basis._01_introduction_to_algorithms;
/**
 * SelectionSort
 *
 * @author ProSayJ
 * @version V1.0.0
 */
public class BinarySearch {
    private static Integer binarySearch(int[] srcList, int target) {
        if (srcList.length == 0) {
            return null;
        }
        //初始化
        int firstIndex = 0;
        int lastIndex = srcList.length - 1;

        //循环体
        while (firstIndex <= lastIndex) {
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
        int[] list = {3};
        // 1
        System.out.println(binarySearch(list, 3));
        // null
        System.out.println(binarySearch(list, -1));
    }
}