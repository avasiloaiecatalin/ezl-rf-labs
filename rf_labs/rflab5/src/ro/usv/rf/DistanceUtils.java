package ro.usv.rf;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DistanceUtils {
	//double[][] learningSet = FileUtils.readLearningSetFromFile("src/in.txt");
	
	protected static double euclidianDistance(double x1, double x2, double y1, double y2) {
		return Math.sqrt(Math.pow(x1-y1, 2) + Math.pow(x2-y2, 2));
	}
	
	protected static double calculateEuclidianDistance(Place x, Place y) {
		double sum = 0.0;
		sum = Math.pow(x.getX() - y.getX(),2)+Math.pow(x.getY(), y.getY());
		return Math.sqrt(sum);
	}
	
	protected static ArrayList<Place> calculateNV(ArrayList<Place> list, Place p, int n) {
		ArrayList<Place> nv = new ArrayList<Place>();
		Place p2;
		DecimalFormat df2 = new DecimalFormat("#.##");
		for(int i=0; i<n; i++) {
			p2 = list.get(i);
			p2.setDistanceToP(Double.valueOf(df2.format(calculateEuclidianDistance(p, p2))));
			nv.add(p2); 
		}
		
		Collections.sort(nv);
		
		for(int i=0; i<nv.size(); i++) {
			System.out.print(nv.get(i).getDistanceToP()+" ");
		}
		
		return nv;
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
				//double x = calculateEuclidianDistance(mainFeature, feature);
				//geu[i][j] = geu[j][i] = new Double(df.format(x));
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
	
}
