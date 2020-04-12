package ro.usv.rf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainClass {

	public static void main(String[] args) {
		SetUtils.prepareSets();
		try {
			ArrayList<Iris> learningSet = FileUtilsForIris.readLearningSetFromFile("train.txt");
			ArrayList<Iris> evalSet = FileUtilsForIris.readLearningSetFromFile("eval.txt");
			ArrayList<String> a = new ArrayList<String>();
			
			for(Iris p: evalSet) {
				a = DistanceUtils.calculateNV(learningSet, p, 60);
				String ap = DistanceUtils.aproxCounty(a);
				System.out.println(p.displayFeatures()+ " => "+ap);
			}
			System.out.println("=== Acc ===");
			for(int i=0; i<100; i++) {
				DistanceUtils.getAccuracy(i, learningSet);
			}
			
			System.out.println("=== ===");
			
			ArrayList<Iris> placesList = FileUtilsForIris.readLearningSetFromFile("eval.txt");
			Map<String, ArrayList<Iris>> placesMap = new HashMap<String, ArrayList<Iris>>();
			for(int i=0; i<placesList.size(); i++) {
				String actualClass = placesList.get(i).getIrisClass();
				ArrayList<Iris> placesMapActualList = new ArrayList<Iris>();
				
				if(placesMap.containsKey(placesList.get(i).getIrisClass())) {
					placesMapActualList = placesMap.get(actualClass);
					placesMapActualList.add(placesList.get(i));
					placesMap.put(actualClass, placesMapActualList);
				}
				else {
					placesMapActualList.add(placesList.get(i));
					placesMap.put(placesList.get(i).getIrisClass(), placesMapActualList);
				}
			}
			
			Iris testiris = placesList.get(7);
			double fiOras = 0.0;
			for(String key:placesMap.keySet()) {
				ArrayList<Iris> myMapActualList = placesMap.get(key);
				ArrayList<Double> wRow = DistanceUtilsForW.getWRowForPlaces(myMapActualList);
				fiOras = DistanceUtilsForW.getFiForPlace(wRow, testiris);
				if(fiOras > testiris.getFi()) {
					testiris.setFi(fiOras);
					testiris.setPredictedClass(key);
				}
			}
			System.out.println("Clasa prezisa pentru "+testiris.displayFeatures()+" este "+testiris.predictedClass);
			
		} catch (USVInputFileCustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
