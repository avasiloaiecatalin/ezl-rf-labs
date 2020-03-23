package ro.usv.rf;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import ro.usv.rf.FileUtils;
import ro.usv.rf.StatisticsUtils;

public class MainClass {
	//lab5
	/*
	 * judetul e clasa 
	 * 17 nn
	 * cei mai apropiati 17
	 * clasa formei e clasa majoritara celor 17 vecini
	 * acuratete -> 
	 * array cu localitatile, cele 3
	 * iterare pe lista, luam una cate una
	 * calculam distanta de la localitatea data la toate celelalte
	 * retinut primele 31
	 * tinem distantele in array --> il sortam dar fara sa uitam indicele initial
	 * treeSet ---> permite ordonarea unui set */
	
	public static void main(String[] args) throws USVInputFileCustomException {
		double[][] learningSet;
		String[][] ls;
		try {
			ls = ro.usv.rf.FileUtils.readLearningSetFromFile("src/data.csv");
			
			learningSet = Helper.returnDoubleArrayFromMixedArray(ls);
			System.out.println(learningSet[0]);
			ro.usv.rf.FileUtils.writeStringLearningSetToFile("outString.txt", ls);
			ro.usv.rf.FileUtils.writeLearningSetToFile("out.txt", learningSet);
			/*FileUtils.writeLearningSetToFile("out.txt", learningSet);
			int numberOfPatterns = learningSet.length;
			int numberOfFeatures = learningSet[0].length;
			System.out.println(String.format("The learning set has %s patters and %s features", numberOfPatterns, numberOfFeatures));
			
			double[][] learningSet2 = new double[numberOfPatterns][numberOfFeatures-1];
			for(int i=0; i<numberOfPatterns; i++) {
				for(int j=0; j<learningSet2[0].length; j++) {
					learningSet2[i][j] = learningSet[i][j];
				}
			}*/
			/*System.out.println("Distanta Euclidiana pt primele 2 forme si primele 2 caracteristici:");
			for(int i=1; i<numberOfPatterns; i++) {
				System.out.println("Dist. euclidiana: " + DistanceUtils.euclidianDistance(learningSet2[0][0], learningSet2[i][0], learningSet[0][1], learningSet[i][1]));
			}
			System.out.println("Distanta Mahalanobis:");
			for(int i=1; i<numberOfPatterns; i++) {
				System.out.println("Dist: " + DistanceUtils.mahalanobisDistance(learningSet2[0], learningSet2[i], numberOfFeatures));
			}
			System.out.println("Distanta Cebisev:");
			for(int i=1; i<numberOfPatterns; i++) {
				System.out.println("Dist: " + DistanceUtils.cebisevDistance(learningSet2[0], learningSet2[i]));
				
			}
			System.out.println("Distanta City Block:");
			for(int i=1; i<numberOfPatterns; i++) {
				System.out.println("Dist: " + DistanceUtils.cityBlockDistance(learningSet2[0], learningSet2[i]));
			}
			
			FileUtils.writeLearningSetToFile("distMat.txt", DistanceUtils.calculateDistanceMatrix(learningSet2));
		*/
			/*double[][] distanceMatrix = DistanceUtils.calculateDistanceMatrix(learningSet2);
			FileUtils.writeLearningSetToFile("distMat.txt", distanceMatrix);
			DistanceUtils.oneNN(learningSet, learningSet.length-1, distanceMatrix);*/
			
		} finally {
			System.out.println("Finished learning set operations");
		}
	}

}
