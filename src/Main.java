import java.util.function.DoubleUnaryOperator;

public class Main {
    public static void main(String[] args) {
        DoubleUnaryOperator logn = i -> Math.log(i) / Math.log(2);
        System.out.println("Algorithm: logn (too efficient to produce meaningful values. values calculated by hand)");
        calculate(logn);
        System.out.print("\n");

        DoubleUnaryOperator rootn = i -> Math.sqrt(i);
        System.out.println("Algorithm: sqrt(n) (also very efficient. didn't produce values after t=1000ms)");
        calculate(rootn);
        System.out.print("\n");


        DoubleUnaryOperator n = i -> i;
        System.out.println("Algorithm: n");
        calculate(n);
        System.out.print("\n");

        DoubleUnaryOperator nlogn = i -> i * Math.log(i) / Math.log(2.0);
        System.out.println("Algorithm: nlogn");
        calculate(nlogn);
        System.out.print("\n");

        DoubleUnaryOperator nsquared = i -> Math.pow(i, 2.0);
        System.out.println("Algorithm: n^2");
        calculate(nsquared);
        System.out.print("\n");

        DoubleUnaryOperator ncubed = i -> Math.pow(i, 3.0);
        System.out.println("Algorithm: n^3");
        calculate(ncubed);
        System.out.print("\n");

        DoubleUnaryOperator twoPwrOfN = i -> Math.pow(2.0, i);
        System.out.println("Algorithm: 2^n");
        calculate(twoPwrOfN);
        System.out.print("\n");

        DoubleUnaryOperator nFactorial = i -> factorial(i);
        System.out.println("Algorithm: n!");
        calculate(nFactorial);
        System.out.print("\n");
    }


    public static void calculate(DoubleUnaryOperator algorithm) {
        double n = 0;
        boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false, flag5 = false;
        for (long i = 0; i < 100000000; i++) {
            n = algorithm.applyAsDouble(i);

            //early return if function doesn't grow fast enough.
            if (i > 1000000 && n < 100){
                break;
            }

            if (n > 1000 && !flag1) {
                flag1 = true;
                System.out.println("1 sec. t = 1000, n = " + (i - 1));
            }

            if (n > 60000 && !flag2) {
                flag2 = true;
                System.out.println("1 min. t = 60,000, n = " + (i - 1));
            }
            if (n > (3.6 * Math.pow(10.0, 6)) && !flag3) {
                flag3 = true;
                System.out.println("1 hr. t = 3.6*10^6, n = " + (i - 1));
            }
            if (n > (8.64 * Math.pow(10.0, 7)) && !flag4) {
                flag4 = true;
                System.out.println("1 day. t = 8.64*10^7, n = " + (i - 1));
            }
            if (n > (2.628 * Math.pow(10.0, 9)) && !flag5) {
                flag5 = true;
                System.out.println("1 month. t = 2.628*10^9, n = " + (i - 1));
                break;
            }
        }
    }

    public static long factorial(double n) {
        long res = 1, i;
        for (i = 2; i <= n; i++)
            res *= i;
        return res;
    }
}