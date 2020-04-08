package ro.usv.rf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass {
	
	
	public static void main(String[] args) {
		double[][] learningSet; 
		try {
			learningSet = FileUtils.readLearningSetFromFile("src/in.txt");
			int numberOfPatterns = learningSet.length;
			int numberOfFeatures = learningSet[0].length-1;
			System.out.println(String.format("The learning set has %s patters.", numberOfPatterns));
			System.out.println(numberOfFeatures);

			Map<Double, ArrayList<Pattern>> myMap = new HashMap<Double, ArrayList<Pattern>>();
			
			for(int i=0; i<learningSet.length; i++) {
				Pattern actualPattern = new Pattern();
				ArrayList<Double> actualPatternFeatures = new ArrayList<Double>();
				double actualClass = 0.0;
				for(int j=0; j<learningSet[i].length-1; j++) {
					actualPatternFeatures.add(learningSet[i][j]);
				}
				actualPattern.setFeatures(actualPatternFeatures);
				actualClass = learningSet[i][learningSet[i].length-1];
				ArrayList<Pattern> myMapActualList = new ArrayList<Pattern>();
				if(myMap.containsKey(actualClass)) {
					myMapActualList = myMap.get(actualClass);
					myMapActualList.add(actualPattern);
					myMap.put(actualClass, myMapActualList);
				}
				else {
					myMapActualList.add(actualPattern);
					myMap.put(actualClass, myMapActualList);
				}
			}
			
			for(Double key: myMap.keySet()) {
				System.out.print("Display for key = "+key+": ");
				System.out.println();
				ArrayList<Pattern> myMapActualList = myMap.get(key);
				for(Pattern p: myMapActualList) {
					System.out.println(p.displayFeatures());
				}
				System.out.println();
			}
			
			// keep here your pattern
			
			Pattern testp = new Pattern(0.0,5.0);
			double actualFi = 0.0;
			for(Double key:myMap.keySet()) {
				ArrayList<Pattern> myMapActualList = myMap.get(key);
				ArrayList<Double> wRow = DistanceUtils.getWRow(myMapActualList);
				actualFi = DistanceUtils.getFi(wRow, testp);
				System.out.println("=>"+actualFi);
				if(actualFi > testp.getFi()) {
					testp.setFi(actualFi);
					testp.setPredictedClass(key);
				}
			}
			System.out.println("Clasa prezisa pentru "+testp.displayFeatures()+" este "+testp.predictedClass);
			
			// orasele aici
			// 25.89 47.56
			ArrayList<Place> placesList = FileUtilsForPlaces.readLearningSetFromFile("src/data.csv");
			Map<String, ArrayList<Place>> placesMap = new HashMap<String, ArrayList<Place>>();
			for(int i=0; i<placesList.size(); i++) {
				String actualClass = placesList.get(i).getPlaceClass();
				ArrayList<Place> placesMapActualList = new ArrayList<Place>();
				
				if(placesMap.containsKey(placesList.get(i).getPlaceClass())) {
					placesMapActualList = placesMap.get(actualClass);
					placesMapActualList.add(placesList.get(i));
					placesMap.put(actualClass, placesMapActualList);
				}
				else {
					placesMapActualList.add(placesList.get(i));
					placesMap.put(placesList.get(i).getPlaceClass(), placesMapActualList);
				}
			}
			/*// aici afisez orasele 
			int x = 0;
			for(String key: placesMap.keySet()) {
				System.out.println();
				System.out.println("Display for key = "+key+": ");
				System.out.println();
				ArrayList<Place> myMapActualList = placesMap.get(key);
				for(Place p: myMapActualList) {
					System.out.println(p.displayFeatures());
					x++;
				}
				System.out.println(x);
			}
			*/
			
			Place testoras = new Place(25.89,47.56);
			double fiOras = 0.0;
			for(String key:placesMap.keySet()) {
				ArrayList<Place> myMapActualList = placesMap.get(key);
				ArrayList<Double> wRow = DistanceUtils.getWRowForPlaces(myMapActualList);
				fiOras = DistanceUtils.getFiForPlace(wRow, testoras);
				if(fiOras > testoras.getFi()) {
					testoras.setFi(fiOras);
					testoras.setPredictedClass(key);
				}
			}
			System.out.println("Orasul prezis pentru "+testoras.displayFeatures()+" este "+testoras.predictedClass);
			
			
			
		} catch (USVInputFileCustomException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Finished learning set operations");
		}
	}

}