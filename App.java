import java.util.Scanner;

public class App {

    public static long binpow(long a, long n) {
        long res = 1;
        while (n > 0) {
            if (n % 2 == 1) { res = res * a; }
            a = a * a;
            n >>= 1;
        }
        return res;
    }

    public static double binpowd(double a, long n) {
        double res = 1;
        while (n > 0) {
            if (n % 2 == 1) { res = res * a; }
            a = a * a;
            n >>= 1;
        }
        return res;
    }

    public static long fi(long a) {
        long f = a, count = 0, i = 2;
        while (a != 1) {
            while (a % i == 0) {
                count++;
                a = a / i;
            }
            if (count != 0) {
                f = f * (i - 1) / i;
            }
            i++;
            count = 0;
        }
        return f;
    }

    public static void main(String[] args) throws Exception {
        //8 25
        //5 27
        Scanner in = new Scanner(System.in);
        long count = 0, i = 2, n, d;
        double b = 0;
        System.out.print("m = ");
        long m = in.nextLong();
        n = fi(m);
        System.out.print("g = ");
        long g = in.nextLong();
        d = n;

        while (n != 1) {
            while (n % i == 0) {
                count++;
                n = n / i;
            }
            if (count != 0) {
                d = d / binpow(i, count);
                b = binpow(g, d) % m;
                while (b != 1) {
                    b = binpowd(b, i) % m;
                    d = d * i;
                }
            }
            i++;
            count = 0;
        }
        System.out.print("d = ");
        System.out.print(d);
    }
}

