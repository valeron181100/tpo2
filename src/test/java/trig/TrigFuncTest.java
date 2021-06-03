package trig;

import MyMath.trig.*;
import MyMath.utils.CsvLogger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Trigonometric function")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TrigFuncTest {
    private TrigonometricFunction trigonometricFunction;
    private CosCalculator cosCalculator;
    private SinCalculator sinCalculator;
    private CoSecCalculator coSecCalculator;
    private TanCalculator tanCalculator;
    private CoTanCalculator coTanCalculator;
    private CsvLogger logger = new CsvLogger("trig_results/cos-results.csv", -15.0, 0.0, 0.5);
    private final double ACCURACY = 0.001;
    private final double DELTA = 0.05;

    @BeforeAll
    void init() {
        this.cosCalculator = new CosCalculator(ACCURACY);
        this.sinCalculator = new SinCalculator(ACCURACY);
        this.coSecCalculator = new CoSecCalculator(ACCURACY);
        this.tanCalculator = new TanCalculator(ACCURACY);
        this.coTanCalculator = new CoTanCalculator(ACCURACY);
        this.trigonometricFunction = new TrigonometricFunction(ACCURACY);
    }

    @ParameterizedTest(name = "X = {0} * PI / {1}")
    @CsvFileSource(resources = "/trig/trig-data.csv")
    @DisplayName("All calculators are stubs")
    void allAreStub(Double numerator, Double denominator, Double expectedResult) {
        double x = numerator * Math.PI / denominator;
        double cosStub = cosCalculator.calculateStub(x);
        double sinStub = sinCalculator.calculateStub(x, cosStub);
        double cscStub = coSecCalculator.calculateStub(sinStub);
        double tanStub = tanCalculator.calculateStub(cosStub, sinStub);
        double cotStub = coTanCalculator.calculateStub(tanStub);
        try {
            double actualResult = trigonometricFunction.calculateTrigFunctionStub(x, cscStub, cotStub, tanStub);
            System.out.println(actualResult);
            assertEquals(expectedResult, actualResult);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }

    @ParameterizedTest(name = "X = {0} * PI / {1}")
    @CsvFileSource(resources = "/trig/trig-data.csv")
    @DisplayName("All calculators aren't stubs")
    void nothingIsStub(Double numerator, Double denominator, Double expectedResult) {
        try {
            double actualResult = trigonometricFunction.calculateFunction(numerator * Math.PI / denominator);
            System.out.println(actualResult);
            assertEquals(expectedResult, actualResult, DELTA);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }

    @Test
    void log() {
        logger.log(cosCalculator);

        logger.setFilePath("trig_results/sin-results.csv");
        logger.setLowerBorder(-5 * Math.PI);
        logger.log(sinCalculator);

        logger.setFilePath("trig_results/csc-results.csv");
        logger.log(coSecCalculator);

        logger.setFilePath("trig_results/tan-results.csv");
        logger.log(tanCalculator);

        logger.setFilePath("trig_results/cot-results.csv");
        logger.log(coTanCalculator);

        logger.setFilePath("trig_results/function-results.csv");
        logger.log(trigonometricFunction);
    }
}