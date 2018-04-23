package yh.algorithm.sort.other;

public class MathUtil
{
    // 我们的算法类不允许产生任何实例
    private MathUtil()
    {
    }

    /**
     * 计算平方根
     *
     * @param x 数
     * @return
     */
    public static double sqrt(double x)
    {
        if (x < 0)
        {
            return -1;
        }
        if (x == 0 || x == 1)
        {
            return x;
        }
        double z = 1;
        double oldz;

        while (true)
        {
            oldz = z;
            z -= (z * z - x) / (2 * z);
            if (oldz == z)
            {
                break;
            }
        }
        return z;
    }

    public static void main(String[] args)
    {
        System.out.println(sqrt(100));
        System.out.println(Math.sqrt(100));
    }
}
