package MyMath.trig;

import MyMath.AbstractFunction;

import static java.lang.Math.PI;

public class TanCalculator extends AbstractFunction {
    private CosCalculator cosCalculator;
    private SinCalculator sinCalculator;

    {
        getStubsTable().put(-PI, 0.0);
        getStubsTable().put(-PI / 2, Double.NEGATIVE_INFINITY);
        getStubsTable().put(0.0, 0.0);
        getStubsTable().put(PI / 2, Double.POSITIVE_INFINITY);
        getStubsTable().put(PI, 0.0);
        getStubsTable().put(3 * PI / 4, -1.0);
        getStubsTable().put(-3 * PI / 4, 1.0);
        getStubsTable().put( PI / 4, 1.0);
        getStubsTable().put(-PI / 4, -1.0);
    }

    public TanCalculator(Double accuracy) {
        super(accuracy);
        this.cosCalculator = new CosCalculator(accuracy);
        this.sinCalculator = new SinCalculator(accuracy);
    }

    public Double calculateFunction(Double x) {
        double cSum = cosCalculator.calculateFunction(x);
        double sSum = sinCalculator.calculateFunction(x);
        double result = sSum/cSum;
        if (Math.abs(result) > Double.POSITIVE_INFINITY)
            return  Double.POSITIVE_INFINITY;
        else if (Math.abs(result) < Double.NEGATIVE_INFINITY)
            return Double.NEGATIVE_INFINITY;
        else
            return result;
    }

    public Double calculateStub(Double cosCalculatorResult, Double sinCalculatorResult) {
        final double INF = Double.POSITIVE_INFINITY;

        double result = sinCalculatorResult/cosCalculatorResult;
        if (Math.abs(result) > Double.POSITIVE_INFINITY)
            return  Double.POSITIVE_INFINITY;
        else if (Math.abs(result) < Double.NEGATIVE_INFINITY)
            return Double.NEGATIVE_INFINITY;
        else
            return result;
    }
}
