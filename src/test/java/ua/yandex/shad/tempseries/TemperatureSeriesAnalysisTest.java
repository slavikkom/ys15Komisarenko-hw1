package ua.yandex.shad.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;

public class TemperatureSeriesAnalysisTest {
    
    @Test
    public void testAverage() {
        double[] temperatureSeries = {1.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.5;
        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, 0.00001);
        
    }
	
	@Test (expected = IllegalArgumentException.class)
	public void testAverageIfEmpty() {
		double[] temperatureSeries = {};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		seriesAnalysis.average();
	}
    
	@Test (expected = IllegalArgumentException.class)
	public void testDevitationIfEmpty() {
		double[] temperatureSeries = {};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		seriesAnalysis.devitation();
	}
	
	@Test
	public void testDevitation() {
		double[] temperatureSeries = {1.0, 2.0, 0.0, -1.0, -7.0};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = 10.0;
		double actualResult = seriesAnalysis.devitation();
		assertEquals(expResult, actualResult, 00001);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testMinIfEmpty() {
		double[] temperatureSeries = {};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		seriesAnalysis.min();
	}
	
	@Test
	public void testMinIfBOTTOMTEMP() {
		double[] temperatureSeries = {-7, 2, 4, -273.15};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = -273.15;
		double actualResult = seriesAnalysis.min();
		assertEquals(expResult, actualResult, 00001);
	}
	
	@Test
	public void testMin() {
		double[] temperatureSeries = {0, 1, 2, 3};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = 0;
		double actualResult = seriesAnalysis.min();
		assertEquals(expResult, actualResult, 00001);
	}
	
	@Test
	public void testMax() {
		double[] temperatureSeries = {-273, 3, 17, 4};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = 17;
		double actualResult = seriesAnalysis.max();
		assertEquals(expResult, actualResult, 00001);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testMaxIfEmpty() {
		double[] temperatureSeries = {};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		seriesAnalysis.max();
	}
	
	@Test
	public void testFindTemperatureClosestToZero() {
	    double[] temperatureSeries = {1, 0.1, -0.1, 0.2};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = 0.1;
		double actualResult = seriesAnalysis.findTempClosestToZero();
		assertEquals(expResult, actualResult, 0.00001);
	}
	
	@Test (expected = IllegalArgumentException.class) 
	public void testFindTemperatureClosestToZeroIfEmpty() {
		double temperatureSeries = {};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		seriesAnalysis.findTempClosestToZero();
	}
}
