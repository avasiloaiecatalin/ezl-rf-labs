package ro.usv.rf;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		ArrayList<Grade> learningSet;
		try {
			learningSet = FileUtils.readLearningSetFromFile("src/gradesClasses.txt");
			int numberOfPatterns = learningSet.size();
			System.out.println(String.format("The learning set has %s patters.", numberOfPatterns));

			ArrayList<String> a = new ArrayList<String>();
			Grade p = new Grade();
			// 25.89 47.56
			int maxNN=0;
			for (int i = 1; i <= 17; i++) {
				p.setNumeric("5.75");
				a = DistanceUtils.calculateNV(learningSet, p, i);
				String ap = DistanceUtils.aproxCounty(a);
				int x = DistanceUtils.getAproxCountyNr(a);
				System.out.println(i+":"+ap+" de "+x+" ori");
				if(x<=i/2)
					maxNN = i-2;
			}
			System.out.println("K max este: "+maxNN);
			for (int i = 100; i >= 0; i--) {
				// DistanceUtils.getAccuracy(i, learningSet);
			}

		} catch (USVInputFileCustomException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Finished learning set operations");
		}
	}

}