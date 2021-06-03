package MyMath.trig;

import MyMath.AbstractFunction;

import static java.lang.Math.PI;

public class CoSecCalculator extends AbstractFunction {
    private SinCalculator sinCalculator;

    {
        getStubsTable().put(-PI, Double.POSITIVE_INFINITY);
        getStubsTable().put(-PI / 2, -1.0);
        getStubsTable().put(0.0, Double.POSITIVE_INFINITY);
        getStubsTable().put(PI / 2, 1.0);
        getStubsTable().put(PI, Double.POSITIVE_INFINITY);
        getStubsTable().put(3 * PI / 4, Math.sqrt(2));
        getStubsTable().put(-3 * PI / 4, -Math.sqrt(2));
        getStubsTable().put( PI / 4, Math.sqrt(2));
        getStubsTable().put(-PI / 4, -Math.sqrt(2));
    }

    public CoSecCalculator(Double accuracy) {
        super(accuracy);
        this.sinCalculator = new SinCalculator(accuracy);
    }

    public Double calculateFunction(Double x) {
        double sum = sinCalculator.calculateFunction(x);
        final double INF = Double.POSITIVE_INFINITY;

        double result = 1/sum;
        if (Math.abs(result) > Double.POSITIVE_INFINITY)
            return  Double.POSITIVE_INFINITY;
        else if (Math.abs(result) < Double.NEGATIVE_INFINITY)
            return Double.NEGATIVE_INFINITY;
        else
            return result;
    }

    public Double calculateStub(Double sinCalculatorResult) {
        final double INF = Double.POSITIVE_INFINITY;

        double result = 1/sinCalculatorResult;
        if (Math.abs(result) > Double.POSITIVE_INFINITY)
            return  Double.POSITIVE_INFINITY;
        else if (Math.abs(result) < Double.NEGATIVE_INFINITY)
            return Double.NEGATIVE_INFINITY;
        else
            return result;
    }
}
