package yh.algorithm.sort.quick;

import yh.algorithm.sort.insertion.InsertionSort;
import yh.algorithm.sort.util.SortTestHelper;

//2路快速排序
public class QuickSort2Ways
{
    // 我们的算法类不允许产生任何实例
    private QuickSort2Ways()
    {
    }


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

        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    //分块
    // 对arr[l...r]部分进行partition操作
    // 双路快速排序的partition
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static <T extends Comparable<T>> int partition(T[] arr, int l, int r)
    {
        //优化2 随机选择标定
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);
        T v = arr[l];
        // arr[l+1...i) <= v; arr(j...r] >= v
        int i = l + 1, j = r;
        while (true)
        {
            while (i <= r && arr[i].compareTo(v) < 0)
            {
                i++;
            }
            while (j >= l + 1 && arr[j].compareTo(v) > 0)
            {
                j--;
            }
            if (i > j)
            {
                break;
            }
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
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
        SortTestHelper.testSort("yh.algorithm.sort.quick.QuickSort2Ways", arr);
    }
}
