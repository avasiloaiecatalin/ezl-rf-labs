package ro.usv.rf;

import java.util.Arrays;
import java.util.Collections;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[][] learningSet = FileUtils.readLearningSetFromFile("src/in.txt");
		FileUtils.writeLearningSetToFile("src/out.csv",normalizeLearningSet(learningSet));
	}

	private static double[][] normalizeLearningSet(double[][] learningSet) {
		double[][] normalizedLearningSet = new double[learningSet.length][learningSet[0].length];
		//.. enter your code here
		
		// xij = (xij-xjmin)/(xjmax-xjmin)
		
		for(int i=0; i<learningSet.length; i++) {
			for(int j=0; j<learningSet[0].length; j++) {
				normalizedLearningSet[i][j] = ((learningSet[i][j] - getMin(learningSet, j))/((getMax(learningSet, j)-getMin(learningSet, j))));
			}
		}
		return normalizedLearningSet;
	}
	
	private static double getMax(double[][] set, int j) {
		double max = set[0][j];
		for(int i=1; i<set.length; i++) {
			if(set[i][j] > max) {
				max = set[i][j];
			}
		}
		return max;
	}
	
	private static double getMin(double[][] set, int j) {
		double min = set[0][j];
		for(int i=1; i<set.length; i++) {
			if(set[i][j] < min) {
				min = set[i][j];
			}
		}
		return min;
	}
}
