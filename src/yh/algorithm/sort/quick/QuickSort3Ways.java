package yh.algorithm.sort.quick;

import yh.algorithm.sort.insertion.InsertionSort;
import yh.algorithm.sort.util.SortTestHelper;

public class QuickSort3Ways
{
    // 我们的算法类不允许产生任何实例
    private QuickSort3Ways() {}


    public static <T extends Comparable<T>> void sort(T[] arr)
    {
        int len = arr.length;
        sort(arr, 0, len - 1);
    }

    private static <T extends Comparable<T>> void sort(T[] arr, int l, int r)
    {
//        if (l >= r)
//        {
//            return;
//        }
        // 对于小规模数组, 使用插入排序
        if (r - l <= 15)
        {
            InsertionSort.sort(arr, l, r);
            return;
        }

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);
        T v = arr[l];

        int lt = l;     // arr[l+1...lt] < v
        int gt = r + 1; // arr[gt...r] > v
        int i = l + 1;    // arr[lt+1...i) == v
        while (i < gt)
        {
            if (arr[i].compareTo(v) < 0)
            {
                swap(arr, i, lt + 1);
                i++;
                lt++;
            } else if (arr[i].compareTo(v) > 0)
            {
                swap(arr, i, gt - 1);
                gt--;
            } else
            { // arr[i] == v
                i++;
            }
        }

        swap(arr, l, lt);

        sort(arr, l, lt - 1);
        sort(arr, gt, r);
    }


    private static void swap(Object[] arr, int i, int j)
    {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args)
    {
        // Quick Sort也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("yh.algorithm.sort.quick.QuickSort3Ways", arr);
    }
}
