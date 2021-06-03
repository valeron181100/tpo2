package MyMath;

import MyMath.log.*;
import MyMath.trig.CoSecCalculator;
import MyMath.trig.CosCalculator;
import MyMath.trig.SinCalculator;
import MyMath.trig.TanCalculator;

public class Test {
    public static double ACCURACY = 0.0001;

    public static void main(String[] args) {
        // (((((log_3(3.14) ^ 3) / (ln(3.14) * log_2(3.14))) ^ 3) + log_10(3.14)) * (((ln(3.14) * log_2(3.14)) - (log_10(3.14) ^ 3)) - (log_5(3.14) * (log_10(3.14) - log_3(3.14)))))
        CosCalculator calculator = new CosCalculator(ACCURACY);
        System.out.println(calculator.calculateFunction(-3*Math.PI/4));
    }
}
