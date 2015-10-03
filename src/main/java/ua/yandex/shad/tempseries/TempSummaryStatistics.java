package ua.yandex.shad.tempseries;

public class TempSummaryStatistics {
    double maxTemp;
	double minTemp;
	double avgTemp;
	double devTemp;
	public TempSummaryStatistics() {
		this.maxTemp = TemperatureSeriesAnalysis.max();
		this.minTemp = TemperatureSeriesAnalysis.min();
		this.avgTemp = TemperatureSeriesAnalysis.average();
		this.devTemp = TemperatureSeriesAnalysis.devitation();
	}
}
