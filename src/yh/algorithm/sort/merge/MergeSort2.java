package yh.algorithm.sort.merge;

import yh.algorithm.sort.util.SortTestHelper;


/**
 * 归并排序
 */
public class MergeSort2
{
    // 我们的算法类不允许产生任何实例
    private MergeSort2() {}

    //外部调用排序
    public static <T extends Comparable<T>> void sort(T[] arr)
    {

        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    //内部使用排序
    //递归使用归并排序,对arr[l...r]的范围进行排序
    private static <T extends Comparable<T>> void sort(T[] arr, int l, int r)
    {
        if (l >= r)
        {
            return;
        }
        int mid = (l + r) / 2;
        //排序[l...mid]
        sort(arr, l, mid);
        //排序[mid+1.....r]
        sort(arr, mid + 1, r);
        //归并
        MergeSort.merge(arr, l, mid, r);
    }



    // 测试MergeSort
    public static void main(String[] args)
    {
        // Merge Sort是我们学习的第一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        // 注意：不要轻易尝试使用SelectionSort, InsertionSort或者BubbleSort处理100万级的数据
        // 否则，你就见识了O(n^2)的算法和O(nlogn)算法的本质差异：）
        int N = 10000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("yh.algorithm.sort.merge.MergeSort2", arr);
        sort(arr);
    }


}
