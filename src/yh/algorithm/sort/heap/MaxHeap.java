package yh.algorithm.sort.heap;


/**
 * 最大堆
 *
 * @param <T>
 */
// 在堆的有关操作中，需要比较堆中元素的大小，所以T需要extends Comparable
public class MaxHeap<T extends Comparable>
{
    protected T data[];//数据
    protected int count;//堆的元素个数
    protected int capacity;//堆的空间

    // 构造函数, 构造一个空堆, 可容纳capacity个元素
    public MaxHeap(int capacity)
    {
        data = (T[]) new Comparable[capacity + 1];//开辟空间
        count = 0;//堆的元素个数
        this.capacity = capacity;
    }

    // 构造函数, 通过一个给定数组创建一个最大堆
    // 该构造堆的过程, 时间复杂度为O(n)
    public MaxHeap(T[] arr)
    {
        int n = arr.length;

        data = (T[]) new Comparable[n + 1];//开辟空间
        this.capacity = n;

        for (int i = 0; i < n; i++)
        {
            data[i + 1] = arr[i];// 堆从1开始
        }
        count = n;

        //heapify
        //第一个非叶子的节点count / 2
        for (int i = count / 2; i >= 1; i--)
        {
            shifDown(i);
        }
    }


    // 返回堆中的元素个数
    public int size()
    {
        return count;
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty()
    {
        return count == 0;
    }

    // 获取最大堆中的堆顶元素
    public T getMax()
    {
        assert (count > 0);
        return data[1];
    }

    // 像最大堆中插入一个新的元素 item
    public void insert(T item)
    {
        assert count + 1 <= capacity;
        data[count + 1] = item;
        count++;
        shifUp(count);
    }

    //********************
    //* 最大堆核心辅助函数
    //********************
    private void shifUp(int k)
    {
        while (k > 1 && data[k / 2].compareTo(data[k]) < 0)
        {
            //交换
            swap(k, k / 2);
            k = k / 2;
        }
    }

    // 从最大堆中取出堆顶元素, 即堆中所存储的最大数据
    public T extractMax()
    {
        assert count > 0;
        T ret = data[1];
        swap(1, count);
        count--;
        shifDown(1);
        return ret;
    }

    private void shifDown(int k)
    {
        while (2 * k <= count)
        {
            int j = 2 * k;
            // data[j] 是 data[2*k]和data[2*k+1]中的最大值
            if (j + 1 <= count && data[j + 1].compareTo(data[j]) > 0)
            {
                j++;
            }
            // 如果当前元素data[k] > data[j] 退出
            if (data[k].compareTo(data[j]) >= 0)
            {
                break;
            }
            // 在此轮循环中,data[k]和data[j]交换位置
            swap(k, j);
            k = j;
        }
    }


    // 交换堆中索引为i和j的两个元素
    private void swap(int i, int j)
    {
        T t = data[i];
        data[i] = data[j];
        data[j] = t;
    }


    public static void main(String[] args)
    {
        MaxHeap maxHeap = new MaxHeap<Integer>(100);
        System.out.println(maxHeap.size());
        System.out.println(maxHeap.getMax());
        System.out.println(maxHeap.isEmpty());
        int N = 100; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)
        for (int i = 0; i < N; i++)
        {
            maxHeap.insert((int) (Math.random() * M));
        }

        Integer[] arr = new Integer[N];
        // 将maxheap中的数据逐渐使用extractMax取出来
        // 取出来的顺序应该是按照从大到小的顺序取出来的
        for (int i = 0; i < N; i++)
        {
            arr[i] = (Integer) maxHeap.extractMax();
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 确保arr数组是从大到小排列的
        for (int i = 1; i < N; i++)
        {
            assert arr[i - 1] >= arr[i];
        }
    }
}
