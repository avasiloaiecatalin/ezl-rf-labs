package ro.usv.rf;

public class DistanceUtils {
	//double[][] learningSet = FileUtils.readLearningSetFromFile("src/in.txt");
	
	protected static double euclidianDistance(double x1, double x2, double y1, double y2) {
		return Math.sqrt(Math.pow(x1-y1, 2) + Math.pow(x2-y2, 2));
	}
	
	protected static void calculateEuclidianDistanceForLearningSet(double[][] ls) {
		double[] mainFeature = ls[0];
		for(int i=1; i<ls.length; i++) {
			double[] feature = ls[i];
			System.out.println("Distance between ["+mainFeature[0]+"]["+mainFeature[1]+"] and ["+feature[0]+"]["+feature[1]+"] is " + euclidianDistance(mainFeature[0], mainFeature[1], feature[0], feature[1]));
		}
	}
	
	protected static double calculateCebisev(double[] x, double[] y) {
		
		// 1 si toate celelalte - trebuie facut
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
