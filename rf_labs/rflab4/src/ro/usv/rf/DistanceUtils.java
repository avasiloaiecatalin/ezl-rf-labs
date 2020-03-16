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
		double[][] geu = new double[ls.length][ls.length-1];
		double[] mainFeature;
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.FLOOR);
		for(int i=0; i<ls.length-1; i++) {
			mainFeature = ls[i];
			for(int j=i+1; j<ls.length-1; j++) {
				double[] feature = ls[j];
				double x = calculateEuclidianDistance(mainFeature, feature);
				geu[i][j] = geu[j][i] = new Double(df.format(x));
			}
		}
		return geu;
	}
	
	protected static void getClassForFeature(int x, double[][] ls, double[][] geu) {
		int classx = 0;
		double min;
		min = geu[x][0];
		for(int i=1; i<geu.length; i++) {
			System.out.println("=>"+geu[x][i]+" "+ls[x][i]);
			if(min > geu[x][i]) {
				min = geu[x][i];
				classx = i;
			}
		}
		System.out.println("class: "+ls[classx][ls.length-1]);
		
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
