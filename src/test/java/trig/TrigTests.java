package trig;

import MyMath.trig.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Trig calculator")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class  TrigTests{
    private CosCalculator cosCalculator;
    private SinCalculator sinCalculator;
    private CoSecCalculator coSecCalculator;
    private TanCalculator tanCalculator;
    private CoTanCalculator coTanCalculator;
    private final double DELTA = 0.05;
    private final double ACCURACY = 0.001;

    @BeforeAll
    void init() {
        this.cosCalculator = new CosCalculator(ACCURACY);
        this.sinCalculator = new SinCalculator(ACCURACY);
        this.coSecCalculator = new CoSecCalculator(ACCURACY);
        this.tanCalculator = new TanCalculator(ACCURACY);
        this.coTanCalculator = new CoTanCalculator(ACCURACY);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trig/cos-data.csv")
    @DisplayName("cos(x) test")
    void cosTest(Double numerator, Double denominator, Double expectedResult) {
        double x = numerator * Math.PI / denominator;

        double actualResult = cosCalculator.calculateFunction(x);
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trig/sin-data.csv")
    @DisplayName("sin(x) test")
    void sinTest(Double numerator, Double denominator, Double expectedResult) {
        double x = numerator * Math.PI / denominator;

        double actualResult = sinCalculator.calculateFunction(x);
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trig/csc-data.csv")
    @DisplayName("csc(x) test")
    void cscTest(Double numerator, Double denominator, Double expectedResult) {
        double x = numerator * Math.PI / denominator;

        double actualResult = coSecCalculator.calculateFunction(x);
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trig/tan-data.csv")
    @DisplayName("tan(x) test")
    void tanTest(Double numerator, Double denominator, Double expectedResult) {
        double x = numerator * Math.PI / denominator;

        double actualResult = tanCalculator.calculateFunction(x);
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trig/cot-data.csv")
    @DisplayName("cot(x) test")
    void cotTest(Double numerator, Double denominator, Double expectedResult) {
        double x = numerator * Math.PI / denominator;

        double actualResult = coTanCalculator.calculateFunction(x);
        assertEquals(expectedResult, actualResult, DELTA);
    }

}
