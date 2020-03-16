package ro.usv.rf;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class DistanceUtils {
	//double[][] learningSet = FileUtils.readLearningSetFromFile("src/in.txt");
	
	protected static double euclidianDistance(double x1, double x2, double y1, double y2) {
		return Math.sqrt(Math.pow(x1-y1, 2) + Math.pow(x2-y2, 2));
	}
	
	protected static double calculateEuclidianDistance(double[] x, double[] y) {
		double sum = 0.0;
		for(int i=0; i<x.length; i++) {
			sum += Math.pow((x[i] - y[i]),2);
		}
		return Math.sqrt(sum);
	}
	
	protected static double[][] calculateDistanceMatrix(double[][] ls) {
		double[][] geu = new double[ls.length][ls.length];
		double[] mainFeature;
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.FLOOR);
		for(int i=0; i<ls.length; i++) {
			mainFeature = ls[i];
			for(int j=i+1; j<ls.length; j++) {
				double[] feature = ls[j];
				double x = calculateEuclidianDistance(mainFeature, feature);
				geu[i][j] = geu[j][i] = new Double(df.format(x));
			}
		}
		return geu;
	}
	
	protected static void getClassForFeature(int x, double[][] ls, double[][] geu) {
		double min;
		int featureClass = 0;
		min = Double.MAX_VALUE;
		for(int i=0; i<geu[x].length; i++) {
			if(i!=x) {
				if(min > geu[x][i]) {
					min = geu[x][i];
					featureClass = i;
				}
			}
		}
		System.out.println("Clasa este: "+ls[featureClass][ls[featureClass].length-1]);
	}
	
	protected static double calculateCebisev(double[] x, double[] y) {
		
		double max = Math.abs(x[0] - y[0]);
		
		for(int i=1; i<x.length; i++) {
			if(Math.abs(x[i]-y[i]) > max) {
				max = Math.abs(x[i]-y[i]);
				
			}
		}
		//System.out.println("Cebisev distance is: "+max);
		return max;
	}
	
	protected static double calculateCityBlock(double[] x, double[] y) {
		double sum = 0.0;
		for(int i=0; i<x.length; i++) {
			sum += Math.abs(x[i]-y[i]);
		}
		return sum;
	}
	
	protected static double calculateMahalanobis(double[] x, double[] y, int n) {
		double sum = 0.0;
		for(int i=0; i<x.length; i++) {
			sum += Math.pow((x[i] - y[i]),n);
		}
		return Math.pow(sum, 1.0/n);
	}
}
