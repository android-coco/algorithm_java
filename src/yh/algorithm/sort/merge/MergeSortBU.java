package yh.algorithm.sort.merge;

import yh.algorithm.sort.insertion.InsertionSort;
import yh.algorithm.sort.util.SortTestHelper;

import static yh.algorithm.sort.merge.MergeSort.merge;

/**
 * 自底向上的归并排序
 */
public class MergeSortBU
{
    // 我们的算法类不允许产生任何实例
    private MergeSortBU() {}

    public static <T extends Comparable<T>> void sort(T[] arr)
    {
        int n = arr.length;

        // Merge Sort Bottom Up 无优化版本
//        for (int sz = 1; sz < n; sz *= 2)
//        {
//            for (int i = 0; i < n - sz; i += sz + sz)
//            // 对 arr[i...i+sz-1] 和 arr[i+sz...i+2*sz-1] 进行归并
//            {
//                merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
//            }
//        }

        // Merge Sort Bottom Up 优化
        // 对于小数组, 使用插入排序优化
        for (int i = 0; i < n; i += 16)
        {
            InsertionSort.sort(arr, i, Math.min(i + 15, n - 1));
        }

        for (int sz = 16; sz < n; sz += sz)
        {
            for (int i = 0; i < n - sz; i += sz + sz)
            // 对于arr[mid] <= arr[mid+1]的情况,不进行merge
            {
                if (arr[i + sz - 1].compareTo(arr[i + sz]) > 0)
                {
                    merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
                }
            }
        }
    }

    // 测试 MergeSort BU
    public static void main(String[] args)
    {

        // Merge Sort BU 也是一个O(nlogn)复杂度的算法，虽然只使用两重for循环
        // 所以，Merge Sort BU也可以在1秒之内轻松处理100万数量级的数据
        // 注意：不要轻易根据循环层数来判断算法的复杂度，Merge Sort BU就是一个反例
        // 关于这部分陷阱，推荐看我的《玩转算法面试》课程，第二章：《面试中的复杂度分析》：）
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("yh.algorithm.sort.merge.MergeSortBU", arr);
    }
}
