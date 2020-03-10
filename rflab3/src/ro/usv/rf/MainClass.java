package ro.usv.rf;

public class MainClass {
	
	
	public static void main(String[] args) {
		double[][] learningSet;
		try {
			learningSet = FileUtils.readLearningSetFromFile("src/in.txt");
			int numberOfPatterns = learningSet.length;
			int numberOfFeatures = learningSet[0].length;
			System.out.println(String.format("The learning set has %s patters and %s features", numberOfPatterns, numberOfFeatures));
			
			DistanceUtils.calculateEuclidianDistanceForLearningSet(learningSet);
			
			for(int i=1; i<learningSet.length; i++) {
				System.out.println("Cebisev: "+DistanceUtils.calculateCebisev(learningSet[0], learningSet[i]));
				System.out.println("City Block: "+ DistanceUtils.calculateCityBlock(learningSet[0], learningSet[i]));
				System.out.println("Mahalanobis: "+ DistanceUtils.calculateMahalanobis(learningSet[0], learningSet[i], learningSet.length));
				System.out.println("");
			}
			
		} catch (USVInputFileCustomException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Finished learning set operations");
		}
	}

}
