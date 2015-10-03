package ua.yandex.shad.tempseries;

public class TempSummaryStatistics {
    double maxTemp;
	double minTemp;
	double avgTemp;
	double devTemp;
	public TempSummaryStatistics() {
		maxTemp = TemperatureSeriesAnalysis.max();
		minTemp = TemperatureSeriesAnalysis.min();
		avgTemp = TemperatureSeriesAnalysis.average();
		devTemp = TemperatureSeriesAnalysis.devitation();
	}
}
