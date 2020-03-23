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
			for(int i=0; i<learningSet.size(); i++) {
				System.out.println(learningSet.get(i).getCounty()+" => "+ learningSet.get(i).getX() + " / " + learningSet.get(i).getY());
			}
			
			ArrayList<Place> a = new ArrayList<Place>();
			Place p = new Place();
			// 25.89 47.56
			p.setX("25.89");
			p.setY("47.56");
			a = DistanceUtils.calculateNV(learningSet, p, 9);
			System.out.println("=========");
			for(int i=0; i<a.size(); i++) {
				System.out.println(a.get(i).getCounty());
			}
		} catch (USVInputFileCustomException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Finished learning set operations");
		}
	}

}