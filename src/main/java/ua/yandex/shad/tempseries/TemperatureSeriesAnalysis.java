package ua.yandex.shad.tempseries;

public class TemperatureSeriesAnalysis {    
    private static final double BOTTOMTEMP = -273.15;
    private double []temps;
    public TemperatureSeriesAnalysis() {
        temps = new double[0];
    }
    
    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        temps = new double[temperatureSeries.length];
        for (int i = 0; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] < BOTTOMTEMP) {
			    throw new ExceptionInInitializerError();
			}
            temps[i] = temperatureSeries[i];	
		}
    }
    
    public double average() { 
	    if (temps.length == 0) {
			throw new IllegalArgumentException();
		}
		double averageTemp = 0;
		for (int i = 0; i < temps.length; i++) {
			averageTemp += temps[i];
		}
        return averageTemp/temps.length;
    }    
    
    public double devitation() {
		if (temps.length == 0) {
			throw new IllegalArgumentException();
		}
		double averagesqrTemp = 0;
		for (int i = 0; i < temps.length; i++) {
			averagesqrTemp += temps[i]*temps[i];
		}
        return averagesqrTemp/temps.length-average()*average();
    }
    
    public double min() {
		if (temps.length == 0) {
			throw new IllegalArgumentException();
		}
		double minimum = temps[0];
		for (int i = 0; i < temps.length; i++) {
			if (minimum >= temps[i]) {
				minimum = temps[i];
			}
		}	
        return minimum;
    }
     
    public double max() {
		if (temps.length == 0) {
			throw new IllegalArgumentException();
		}
        double maximum = temps[0];
		for (int i = 0; i < temps.length; i++) {
			if (maximum <= temps[i]) {
				maximum = temps[i];
			} 
	    }	
        return maximum;
    }
    
    public double findTempClosestToZero() {
        if (temps.length == 0) {
			throw new IllegalArgumentException();
		}
		double closestToZero = temps[0];
		for (int i = 0; i < temps.length; i++) {
			if (Math.abs(closestToZero) >= Math.abs(temps[i])) {
				closestToZero = temps[i];
				if ((Math.abs(closestToZero -temps[i]) < 0.0001)
					&& (temps[i] < 0)) {
					closestToZero = -temps[i];
				}
			}
		}
		return closestToZero;
    }
    
    public double findTempClosestToValue(double tempValue) {
		if (temps.length == 0) {
			throw new IllegalArgumentException();
		}
		double closestTotempValue = temps[0];
		double minimum = Math.abs(closestTotempValue - temps[0]);
		for (int i = 0; i < temps.length; i++) {
			if (Math.abs(closestTotempValue - temps[i]) < minimum) {
				closestTotempValue = temps[i];
				minimum = 
				Math.abs(closestTotempValue - temps[i]);
			}
		}	
		return closestTotempValue;
	}
    
    public double [] findTempsLessThen(double tempValue) {
		int count = 0;
		if (temps.length == 0) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < temps.length; i++) {
			if (temps[i] < tempValue) {
				count++; 
			}
		}	 
		double [] tempLessThen = new double [count];
		count = 0;
		for (int i = 0; i < temps.length; i++) {
			if (temps[i] < tempValue) {
				count++;
				tempLessThen[count] = temps[i];
			}
		}
        return tempLessThen;
    }
    
    public double [] findTempsGreaterThen(double tempValue) {
		int count = 0;
		if (temps.length == 0) {
			throw new IllegalArgumentException();
		}
	    for (int i = 0; i < temps.length; i++) {
			if (temps[i] > tempValue) {
				count++;
			}	
		}	
		double [] tempGreaterThen = new double [count];
		count = 0;
		for (int i = 0; i < temps.length; i++){
	        if (temps[i] > tempValue) {
				count++;
				tempGreaterThen[count] = temps[i];
			} 
		}
        return tempGreaterThen;
    }
    
	static final class TempSummaryStatistics {
		private double avgTemp;
		private double devTemp;
		private double minTemp;
		private double maxTemp;
	}
	
    public TempSummaryStatistics summaryStatistics() {
		TempSummaryStatistics summaryStat = new TempSummaryStatistics();
		if (temps.length == 0) { 
			throw new IllegalArgumentException();
		}
		summaryStat.avgTemp = average();
		summaryStat.devTemp = devitation();
		summaryStat.minTemp = min();
		summaryStat.maxTemp = max();
        return summaryStat;
    }
    
    public int addTemps(double ... temperatures) {
		double []tmp = new double [temps.length + temperatures.length];
		for (int i = 0; i < temps.length; i++) {
			tmp[i] = temps[i];
		}
		for (int i = 0; i < temperatures.length; i++) {
			tmp[temps.length + i] = temperatures[i];
			if (temperatures[i] < BOTTOMTEMP) {
		        throw new IllegalArgumentException();
			}
		}
		temps = tmp;
        return 0;
    }
}
