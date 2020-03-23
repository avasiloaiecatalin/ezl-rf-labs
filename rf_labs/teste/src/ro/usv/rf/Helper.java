package ro.usv.rf;

public class Helper {

	static double[][] returnDoubleArrayFromMixedArray(String[][] learningSet){
		double[][] finalArray = new double[learningSet.length][];
		for(int i=0; i<learningSet.length; i++) {
			finalArray[i] = new double[learningSet[i].length];
			for(int j=0; j<learningSet[i].length; j++) {
					try{
						finalArray[i][j] = Double.valueOf(learningSet[i][j]);
					}catch(Exception e) {
						
					}
				
			}
		}
		return finalArray;
	}
}
