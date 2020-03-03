package ro.usv.rf;

import java.util.HashMap;
import java.util.Map;

public class StatisticsUtils 
{

	protected static double calculateFeatureAverage(Double[] feature) {
		Map<Double, Integer> counterMap = getFeatureDistincElementsCounterMap(feature);
		double featureAverage = 0;

		double sum1 = 0;
		double sum2 = 0;

		sum1 = counterMap.keySet().stream()
				.mapToDouble(x -> calculateSum1(x, counterMap.get(x))).sum();
		sum2 = counterMap.values().stream()
				.mapToInt(x -> x).sum();
		featureAverage = sum1 / sum2;
		System.out.println("The feature average is: " +  featureAverage);
		return featureAverage;
}
	
	protected static Map<Double, Integer> getFeatureDistincElementsCounterMap(Double feature[])
	{
		Map<Double, Integer> counterMap = new HashMap<Double, Integer>();
		for (int j = 0; j < feature.length; j++) {
			if (counterMap.containsKey(feature[j])) {
				int count = counterMap.get(feature[j]);
				counterMap.put((feature[j]), ++count);
			} else {
				counterMap.put((feature[j]), 1);
			}
		}
		return counterMap;
	}
	
	private static Double calculateSum1(double value, int count)
	{
		return count * value;
	}

	protected static double calculateFeatureWeightedAverage(Double[] feature, Double[] weights) {
		double featureWeightedAverage = 0.0;
		int mapSum = 0;
		// your code here
		Map<Double,Double> weightAverage = new HashMap<Double, Double>();
		for (int j = 0; j < feature.length; j++) {
			mapSum += weights[j];
			if(weightAverage.containsKey(feature[j])) {
				weightAverage.put(feature[j], weightAverage.get(feature[j])+weights[j]);
			}else {
				weightAverage.put(feature[j], weights[j]);
			}
		}
		for(int j=0; j<feature.length; j++) {
			featureWeightedAverage += feature[j]*weightAverage.get(feature[j]);
		}
		
		return featureWeightedAverage / mapSum;
	}
	
	protected static double calculateFrequencyOfOccurence(Map<Double, Integer> counterMap, double featureElement) {
		int countFeature = 0;
		double countElements = 0.0;
		if(counterMap.containsKey(featureElement)) {
			countFeature = counterMap.get(featureElement);
			countElements = counterMap.values().stream().mapToDouble(x->x).sum();
			return countFeature / countElements;
		}else {
			return 0;
		}
	}
	
	protected static double calculateFeatureDispersion(Double[] feature, double featureWeightedAverage) {
		double featureDispersion = 0.0;
		double sum = 0;
		for(int j = 0; j<feature.length; j++) {
			sum += Math.pow(feature[j] - featureWeightedAverage, 2);
		}
		featureDispersion = 1.0 / (feature.length - 1) * sum;
		return featureDispersion;
	}
	
	protected static double calculateCovariance(Double[] feature1, Double[] feature2, 
			double feature1WeightedAverage,double feature2WeightedAverage) {
		double covariance = 0.0;
		double sum = 0;
		for(int j = 0; j<feature1.length; j++) {
			sum += (feature1[j] - feature1WeightedAverage) * (feature2[j] - feature2WeightedAverage);
		}
		covariance = 1.0 / (feature1.length-1)*sum;
		return covariance;
	}
	
	protected static double calculateCorrelationCoefficient(double covariance, double feature1Dispersion, 
			double feature2Dispersion ) {
		return covariance / (Math.sqrt(feature1Dispersion * feature2Dispersion));
	}
	
	protected static double calculateAverageSquareDeviation(double featureDispersion ) {
		return Math.sqrt(featureDispersion);
	}
}
