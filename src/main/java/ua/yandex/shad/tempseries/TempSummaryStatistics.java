package ua.yandex.shad.tempseries;

public class TempSummaryStatistics {
    private double maxTemp;
    private double minTemp;
    private double avgTemp;
    private double devTemp;
	
	public setMaxTemp(double a) {
		this.maxTemp = a;
	}
	
	public setMinTemp(double a) {
		this.minTemp = a;
	}
	
	public setAvgTemp(double a) {
		this.avgTemp = a;
	}
	
	public setDevTemp(double a) {
		this.devTemp = a;
	}
	
	public getMinTemp() {
		return this.minTemp;
	}
	
	public getMaxTemp() {
		return this.maxTemp;
	}
	
	public getAvgTemp() {
		return this.avgTemp;
	}
	
	public getDevTemp() {
		return this.devTemp;
	}
	
	public TempSummaryStatistics() {
		setMaxTemp(0);
		setMinTemp(0);
		setavgTemp(0);
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
		setavgTemp(seriesAnalysis.average());
		setDevTemp(seriesAnalysis.devitation());
	}
}
