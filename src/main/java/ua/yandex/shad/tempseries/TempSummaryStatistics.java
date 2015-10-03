package ua.yandex.shad.tempseries;

public class TempSummaryStatistics {
    private double maxTemp;
    private double minTemp;
    private double avgTemp;
    private double devTemp;
	
	public void setMaxTemp(double a) {
		this.maxTemp = a;
	}
	
	public void setMinTemp(double a) {
		this.minTemp = a;
	}
	
	public void setAvgTemp(double a) {
		this.avgTemp = a;
	}
	
	public void setDevTemp(double a) {
		this.devTemp = a;
	}
	
	public double getMinTemp() {
		return this.minTemp;
	}
	
	public double getMaxTemp() {
		return this.maxTemp;
	}
	
	public double getAvgTemp() {
		return this.avgTemp;
	}
	
	public double getDevTemp() {
		return this.devTemp;
	}
	
	public TempSummaryStatistics() {
		setMaxTemp(0);
		setMinTemp(0);
		setAvgTemp(0);
		setDevTemp(0);
	} 
	
	public TempSummaryStatistics(double[] temperatureSeries) {
		if (temperatureSeries.length == 0) { 
			throw new IllegalArgumentException();
		}
		TemperatureSeriesAnalysis seriesAnalysis = 
		new TemperatureSeriesAnalysis(temperatureSeries);
		setMaxTemp(seriesAnalysis.max());
		setMinTemp(seriesAnalysis.min());
		setAvgTemp(seriesAnalysis.average());
		setDevTemp(seriesAnalysis.devitation());
	}
}
