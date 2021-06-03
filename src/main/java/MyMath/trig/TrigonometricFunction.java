package MyMath.trig;

import MyMath.AbstractFunction;

public class TrigonometricFunction extends AbstractFunction {

        private CoSecCalculator cscCalculator;

        private CoTanCalculator cotCalculator;

        private  TanCalculator tanCalculator;

    public TrigonometricFunction(Double accuracy) {
        super(accuracy);
        this.cscCalculator = new CoSecCalculator(accuracy);
        this.cotCalculator = new CoTanCalculator(accuracy);
        this.tanCalculator = new TanCalculator(accuracy);
    }

    /**
     * (((((cot(x) + csc(x)) ^ 2) / (tan(x) - cot(x))) * tan(x)) * tan(x))
     **/
    public Double calculateFunction(Double x) throws IllegalArgumentException {
        if (x > 0.0) {
            throw new IllegalArgumentException("X должен быть меньше или равен нулю");
        }

        double cosResult = new CosCalculator(getAccuracy()).calculateFunction(x);
        double sinResult = new SinCalculator(getAccuracy()).calculateFunction(x);
        double cscResult = this.cscCalculator.calculateFunction(x);
        double cotResult = this.cotCalculator.calculateFunction(x);
        double tanResult = this.tanCalculator.calculateFunction(x);

        return (Math.pow(cotResult + cscResult, 2) / (tanResult - cotResult)
                * tanResult * tanResult
        );
    }

    public double calculateTrigFunctionStub(Double x, Double cscResult, Double cotResult, Double tanResult) throws IllegalArgumentException {
        if (x > 0.0) {
            throw new IllegalArgumentException("X должен быть меньше или равен нулю");
        }

        return (Math.pow(cotResult + cscResult, 2) / (tanResult - cotResult)
                * tanResult * tanResult
        );
    }
}
