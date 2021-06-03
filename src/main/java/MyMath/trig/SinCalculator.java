package MyMath.trig;

import MyMath.AbstractFunction;

import static java.lang.Math.PI;

public class SinCalculator extends AbstractFunction {
    private CosCalculator cosCalculator;

    {
        getStubsTable().put(-PI, 0.0);
        getStubsTable().put(-PI / 2, -1.0);
        getStubsTable().put(0.0, 0.0);
        getStubsTable().put(PI / 2, 1.0);
        getStubsTable().put(PI, 0.0);
        getStubsTable().put(3 * PI / 4, 1/Math.sqrt(2));
        getStubsTable().put(-3 * PI / 4, -1/Math.sqrt(2));
        getStubsTable().put( PI / 4, 1/Math.sqrt(2));
        getStubsTable().put(-PI / 4, -1/Math.sqrt(2));
    }

    public SinCalculator(Double accuracy) {
        super(accuracy);
        this.cosCalculator = new CosCalculator(accuracy);
    }

    public Double calculateFunction(Double x) {
        double sum = cosCalculator.calculateFunction(x);
        final double INF = Double.POSITIVE_INFINITY;
        double result = Math.sqrt(1-(sum*sum));

        if (Math.abs(result) > Double.POSITIVE_INFINITY)
            return  Double.POSITIVE_INFINITY;
        else if (Math.abs(result) < Double.NEGATIVE_INFINITY)
            return Double.NEGATIVE_INFINITY;

        if (x < 0)
            result *= -1;

        return result;
    }

    public Double calculateStub(Double x, Double cosCalculatorResult) {
        final double INF = Double.POSITIVE_INFINITY;
        double result = Math.abs(Math.sqrt(1-(cosCalculatorResult*cosCalculatorResult))) > INF ? INF : Math.sqrt(1-(cosCalculatorResult*cosCalculatorResult));
        if (x < 0)
            result *= -1;
        return result;
    }
}
