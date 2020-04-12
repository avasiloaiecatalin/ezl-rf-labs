package ro.usv.rf;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

public class DistanceUtils {
	protected static double calculateEuclidianDistance(Iris x, Iris y) {
		double sum = 0.0;
		for(int i=0; i<x.getFeatures().size(); i++) {
			sum += Math.pow(x.getFeature(i) - y.getFeature(i),2);
		}
		//sum = Math.pow(x.getX() - y.getX(),2)+Math.pow(x.getY() - y.getY(),2);
		return Math.sqrt(sum);
	}
	
	protected static ArrayList<String> calculateNV(ArrayList<Iris> list, Iris p, int n) {
		IrisComparator pc = new IrisComparator();
		PriorityQueue<Iris> nv = new PriorityQueue<Iris>(pc);
		ArrayList<String> goodNV = new ArrayList<String>();
		//System.out.println("my place: " + p.getX()+" "+p.getY());

		for(int i=0; i<list.size(); i++) {

			Iris p2 = list.get(i);
			p2.setClassFactor(calculateEuclidianDistance(p, p2));
			nv.add(p2);
		}
		//System.out.println(nv.size());
		
		for(int i=0; i<n; i++) {
			goodNV.add(nv.remove().getIrisClass());
		}
		return goodNV;
	}
	
	protected static String aproxCounty(ArrayList<String> nv) {
		HashMap<String, Integer> app = new HashMap<String, Integer>();
		for(int i=0; i<nv.size(); i++) {
			if(app.containsKey(nv.get(i))) {
				int actual = app.get(nv.get(i))+1;
				app.put(nv.get(i), actual);
			}
			else {
				app.put(nv.get(i), 1);
			}
		}
		 
		 int max = 0;
		 String cityWithMax = "";
		 for (Map.Entry<String,Integer> entry : app.entrySet())  {
	            if(max < entry.getValue()) {
	            	max = entry.getValue();
	            	cityWithMax = entry.getKey();
	            }
	    }
		return cityWithMax;
	}
	
	protected static int getAccuracy(int n, ArrayList<Iris> givenList) {
		int acc = 0;
		ArrayList<Iris> neededList = new ArrayList<Iris>();
		try {
			neededList = FileUtilsForIris.readLearningSetFromFile("eval.txt");
		} catch (USVInputFileCustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0; i<neededList.size(); i++) {
			String trueCounty = neededList.get(i).getIrisClass();
			String aproxCounty = aproxCounty(calculateNV(givenList, neededList.get(i), n));
			if(trueCounty.equals(aproxCounty)) {
				acc++;
			}
		}
		double percentage = (double)acc/neededList.size()*100;
		System.out.println("Acc for "+n+" ="+percentage);
		return acc;
	}
	
	protected static void sortAcc() {
		ArrayList<Integer> accArray = new ArrayList<Integer>();
		//if()
	}
}
