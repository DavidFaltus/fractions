package pro1;

public class Utils {

    public static long gcd(long a, long b)
    {
    if (b == 0) return a;
    return gcd(b, a % b);
    }
}
