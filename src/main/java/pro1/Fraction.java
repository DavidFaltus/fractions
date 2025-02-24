package pro1;

public class Fraction
{
    long n; //čitatel
    long d; //jmenovatel

    public Fraction(long n, long d) {
        long gcd = NumericUtils.gcd(d, n);
        this.n = n;
        this.d = d;
    }

    public static Fraction parse(String s){

        return new Fraction(1,1);
    }

    @Override
    public String toString() {
        return n + "/" + d;
    }
}


