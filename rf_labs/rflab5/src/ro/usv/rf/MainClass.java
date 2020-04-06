package ro.usv.rf;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
	
	
	public static void main(String[] args) {
		ArrayList<Place> learningSet;
		double[][] geu;
		try {
			learningSet = FileUtils.readLearningSetFromFile("src/data.csv");
			int numberOfPatterns = learningSet.size();
			System.out.println(String.format("The learning set has %s patters.", numberOfPatterns));
			
			ArrayList<String> a = new ArrayList<String>();
			Place p = new Place();
			// 25.89 47.56
			p.setX("25.89");
			p.setY("47.56");
			a = DistanceUtils.calculateNV(learningSet, p, 31);
			String ap = DistanceUtils.aproxCounty(a);
			System.out.println(ap);
			for(int i=100; i>=0; i--) {
				DistanceUtils.getAccuracy(i, learningSet);
			}
			
		} catch (USVInputFileCustomException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Finished learning set operations");
		}
	}

}