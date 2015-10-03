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
	
	@Test
    public void testAverageIfOneElement() {
        double[] temperatureSeries = {2.1};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 2.1;
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
	
	@Test
	public void testDevitationIfOneEl() {
		double[] temperatureSeries = {1.0};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = 1.0;
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
	public void testMinIfOneElement() {
		double[] temperatureSeries = {0};
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
	
	@Test
	public void testMaxIfOneEl() {
		double[] temperatureSeries = {3};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = 3;
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
	
	@Test
	public void testFindTemperatureClosestToZeroIfOneElement() {
	    double[] temperatureSeries = {1};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = 1;
		double actualResult = seriesAnalysis.findTempClosestToZero();
		assertEquals(expResult, actualResult, 0.00001);
	}
	
	@Test (expected = IllegalArgumentException.class) 
	public void testFindTemperatureClosestToZeroIfEmpty() {
		double[] temperatureSeries = {};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		seriesAnalysis.findTempClosestToZero();
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testFindTemperatureClosestToValueIfEmpty() {
		double[] temperatureSeries = {};
		double value = 1;
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		seriesAnalysis.findTempClosestToValue(value);
	}
	
	@Test 
	public void testFindTemperatureClosestToValue() {
		double[] temperatureSeries = {1, 2.2, 1.8, 3};
		double value = 2;
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double expResult = 2.2;
		double actualResult = seriesAnalysis.findTempClosestToValue(value);
		assertEquals(expResult,actualResult, 0.0001);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testFindTempsLessThanIfEmpty() {
		double[] temperatureSeries = {};
		double tempValue = 0;
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		seriesAnalysis.findTempsLessThen(tempValue);
	}
	
	@Test 
	public void testFindTempsLessThen() {
		double[] temperatureSeries = {1, 0.001, 2.2, -273, -3, 1.01};
		double tempValue = 1;
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double[] expResult = {0.001, -273, -3};
		double[] actualResult = seriesAnalysis.findTempsLessThen(tempValue);
		assertArrayEquals(expResult, actualResult, 0.0001);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testFindTempsGreaterThenIfEmpty() {
		double[] temperatureSeries = {};
		double tempValue = 0;
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		seriesAnalysis.findTempsGreaterThen(tempValue);
	}
	
	@Test
	public void testFindTempsGreaterThen() {
		double[] temperatureSeries = {0.99, 1.01, 2, -2, -272, 3};
		double tempValue = 1;
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double[] expResult = {1.01, 2, 3};
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(tempValue);
        assertArrayEquals(expResult, actualResult, 0.0001);		
	}
	
	@Test
	public void testFindTempGreaterThenIfOneElement() {
		double[] temperatureSeries = {1};
		double tempValue = 1;
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double[] expResult = {};
		double[] actualResult = seriesAnalysis.findTempsGreaterThen(tempValue);
		assertArrayEquals(expResult, actualResult, 0.0001);
	}
	
	@Test
	public void testFindTempLessThenIfOneElement() {
		double[] temperatureSeries = {2};
		double tempValue = 3;
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		double[] expResult = {2};
		double[] actualResult = seriesAnalysis.findTempsLessThen(tempValue);
		assertArrayEquals(expResult, actualResult, 0.0001);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testAddTempsIfEmpty() {
		double[] temperatureSeries = {1, 2};
		double[] temperetures = {-274, 2, 3};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		seriesAnalysis.addTemps(temperetures);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSummaryStatisticIfEmpty() {
		double[] temperatureSeries = {};
		TempSummaryStatistics summaryStat = new TempSummaryStatistics();
		summaryStat.summaryStatistics(temperatureSeries);
	}
	
	
}
