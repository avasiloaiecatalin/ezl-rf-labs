package ro.usv.rf;

public class MainClass {
	
	
	public static void main(String[] args) {
		double[][] learningSet;
		double[][] geu;
		try {
			learningSet = FileUtils.readLearningSetFromFile("src/in.txt");
			int numberOfPatterns = learningSet.length;
			int numberOfFeatures = learningSet[0].length;
			System.out.println(String.format("The learning set has %s patters and %s features", numberOfPatterns, numberOfFeatures));
			
			
			
			for(int i=1; i<learningSet.length; i++) {
				System.out.println("Cebisev: "+DistanceUtils.calculateCebisev(learningSet[0], learningSet[i]));
				System.out.println("City Block: "+ DistanceUtils.calculateCityBlock(learningSet[0], learningSet[i]));
				System.out.println("Mahalanobis: "+ DistanceUtils.calculateMahalanobis(learningSet[0], learningSet[i], learningSet.length));
				System.out.println("");
			}
			
			geu = DistanceUtils.calculateDistanceMatrix(learningSet);
			
			for(int i=0; i<geu.length; i++) {
				for(int j=0; j<geu[i].length; j++) {
					System.out.print(geu[i][j]+" ");
				}
				System.out.println("");
			}
			
			DistanceUtils.getClassForFeature(4, learningSet, geu);
			
		} catch (USVInputFileCustomException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Finished learning set operations");
		}
	}

}