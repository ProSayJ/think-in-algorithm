package prosayj.thinking.algorithm.basis._05_sorts;

import java.util.Arrays;

/**
 * 冒泡排序、插入排序、选择排序
 * <p>
 * Author: Zheng
 */
public class BubbleSort {



    // 插入排序，a表示数组，n表示数组大小
    public static void insertionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找要插入的位置并移动数据
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }

    // 选择排序，a表示数组，n表示数组大小
    public static void selectionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n - 1; ++i) {
            // 查找最小值
            int minIndex = i;
            for (int j = i + 1; j < n; ++j) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }

            // 交换
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }

}
