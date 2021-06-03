package MyMath.trig;

import MyMath.AbstractFunction;

import static java.lang.Math.PI;

public class CoTanCalculator extends AbstractFunction {
    private TanCalculator tanCalculator;

    {
        getStubsTable().put(-PI, Double.POSITIVE_INFINITY);
        getStubsTable().put(-PI / 2, 0.0);
        getStubsTable().put(0.0, Double.POSITIVE_INFINITY);
        getStubsTable().put(PI / 2, 0.0);
        getStubsTable().put(PI, Double.NEGATIVE_INFINITY);
        getStubsTable().put(3 * PI / 4, -1.0);
        getStubsTable().put(-3 * PI / 4, 1.0);
        getStubsTable().put( PI / 4, 1.0);
        getStubsTable().put(-PI / 4, -1.0);
    }

    public CoTanCalculator(Double accuracy) {
        super(accuracy);
        this.tanCalculator = new TanCalculator(accuracy);
    }

    public Double calculateFunction(Double x) {
        double sum = tanCalculator.calculateFunction(x);
        final double INF = Double.POSITIVE_INFINITY;

        double result = 1/sum;
        if (Math.abs(result) > Double.POSITIVE_INFINITY)
            return  Double.POSITIVE_INFINITY;
        else if (Math.abs(result) < Double.NEGATIVE_INFINITY)
            return Double.NEGATIVE_INFINITY;
        else
            return result;
    }

    public Double calculateStub(Double tanCalculatorResult) {
        final double INF = Double.POSITIVE_INFINITY;

        double result = 1/tanCalculatorResult;
        if (Math.abs(result) > Double.POSITIVE_INFINITY)
            return  Double.POSITIVE_INFINITY;
        else if (Math.abs(result) < Double.NEGATIVE_INFINITY)
            return Double.NEGATIVE_INFINITY;
        else
            return result;
    }
}
