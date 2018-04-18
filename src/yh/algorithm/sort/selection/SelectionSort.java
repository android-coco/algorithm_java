package yh.algorithm.sort.selection;

import yh.algorithm.sort.util.SortTestHelper;

/**
 * 泛型
 * Selection-Sort-Generate-Test-Cases
 */

/**
 * 第一趟排序： 原始数据：5  2  8  4  9  1
 *
 * 最小数据1，把1放在首位，也就是1和5互换位置，
 *
 * 排序结果：1  2  8  4  9  5
 *
 * -------------------------------------------------------
 *
 * 第二趟排序：
 *
 * 第1以外的数据{2  8  4  9  5}进行比较，2最小，
 *
 * 排序结果：1  2  8  4  9  5
 *
 * -------------------------------------------------------
 *
 * 第三趟排序：
 *
 * 除1、2以外的数据{8  4  9  5}进行比较，4最小，8和4交换
 *
 * 排序结果：1  2  4  8  9  5
 *
 * -------------------------------------------------------
 *
 * 第四趟排序：
 *
 * 除第1、2、4以外的其他数据{8  9  5}进行比较，5最小，8和5交换
 *
 * 排序结果：1  2  4  5  9  8
 *
 * -------------------------------------------------------
 *
 * 第五趟排序：
 *
 * 除第1、2、4、5以外的其他数据{9  8}进行比较，8最小，8和9交换
 *
 * 排序结果：1  2  4  5  8  9
 */
public class SelectionSort
{
    // 我们的算法类不允许产生任何实例
    private SelectionSort()
    {
    }

    public static <T extends Comparable<T>> void sort(T[] arr)
    {
        int n = arr.length;
        for (int i = 0; i < n; i++)
        {
            // 寻找[i, n)区间里的最小值的索引
            int minIndex = i;
            for (int j = i + 1; j < n; j++)
            {
                // 使用compareTo方法比较两个Comparable对象的大小
                if (arr[j].compareTo(arr[minIndex]) < 0)
                {
                    minIndex = j;
                }
            }
            //如果不是无序区的最小值位置不是默认的第一个数据，则交换之。
            if (minIndex != i)
            {
                swap(arr, i, minIndex);
            }
        }
    }

    //交换
    private static void swap(Object[] arr, int i, int j)
    {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args)
    {
        // 测试排序算法辅助函数
        int N = 100000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 1000000);
        SortTestHelper.testSort("yh.algorithm.sort.selection.SelectionSort", arr);
        //sort(arr);
        //SortTestHelper.printArray(arr);
    }
}
