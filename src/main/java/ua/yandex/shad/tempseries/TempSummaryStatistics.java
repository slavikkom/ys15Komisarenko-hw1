package ua.yandex.shad.tempseries;

public class TempSummaryStatistics {
    double maxTemp;
	double minTemp;
	double avgTemp;
	double devTemp;
	public TempSummaryStatistics(double[] temperatureSeries) {
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
		this.maxTemp = seriesAnalysis.max();
		this.minTemp = seriesAnalysis.min();
		this.avgTemp = seriesAnalysis.average();
		this.devTemp = seriesAnalysis.devitation();
	}
}
