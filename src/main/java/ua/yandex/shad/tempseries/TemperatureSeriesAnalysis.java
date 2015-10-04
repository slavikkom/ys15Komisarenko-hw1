package ua.yandex.shad.tempseries;

public class TemperatureSeriesAnalysis {    
    private static final double BOTTOMTEMP = -273.15;
    private static final double EPS = 0.00001;
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
	
	public double [] getTemps() {
		return this.temps;
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
				if ((Math.abs(Math.abs(closestToZero)
					- Math.abs(temps[i])) < EPS)
					&& (temps[i]*closestToZero < 0)) {
					closestToZero = Math.abs(temps[i]);
				} else {
			    closestToZero = temps[i];     
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
		double minimum = Math.abs(tempValue - temps[0]);
		for (int i = 0; i < temps.length; i++) {
			if (Math.abs(tempValue - temps[i]) < minimum) {
				if ((Math.abs(temps[i] 
				+ closestTotempValue 
				- 2*tempValue) < EPS)
				&& (temps[i] < tempValue)) {
					closestTotempValue = 
					tempValue + Math.abs(temps[i]
					- tempValue);
					} else {
				    closestTotempValue = temps[i];
				    minimum = 
				    Math.abs(closestTotempValue - temps[i]);
			        }
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
				tempLessThen[count] = temps[i];
				count++;
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
		for (int i = 0; i < temps.length; i++) {
	        if (temps[i] > tempValue) {
				tempGreaterThen[count] = temps[i];
				count++;
			} 
		}
        return tempGreaterThen;
    }
	
	
    public TempSummaryStatistics summaryStatistics() {
		TempSummaryStatistics summaryStat = 
		new TempSummaryStatistics(temps);
		if (temps.length == 0) { 
			throw new IllegalArgumentException();
		}
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
		System.arraycopy(temps, 0, tmp, 0, temps.length);
        return 0;
    }
	
}
