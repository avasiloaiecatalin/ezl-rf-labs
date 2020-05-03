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
	protected static double calculateEuclidianDistance(Place x, Place y) {
		double sum = 0.0;
		sum = Math.pow(x.getX() - y.getX(),2)+Math.pow(x.getY() - y.getY(),2);
		return Math.sqrt(sum);
	}
	
	protected static double calculateGradesDif(Grade a, Grade b) {
		return Math.abs(a.getNumeric() - b.getNumeric());
	}
	
	protected static ArrayList<String> calculateNV(ArrayList<Grade> list, Grade p, int n) {
		GradesComparator gc = new GradesComparator();
		PriorityQueue<Grade> nv = new PriorityQueue<Grade>(gc);
		
		ArrayList<String> goodNV = new ArrayList<String>();
		//System.out.println("my place: " + p.getX()+" "+p.getY());

		for(int i=0; i<list.size(); i++) {

			Grade p2 = list.get(i);
			p2.setDifToG(calculateGradesDif(p, p2));
			nv.add(p2);
		}
		//System.out.println(nv.size());
		
		for(int i=0; i<n; i++) {
			goodNV.add(nv.remove().getClassName());
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
		 
		//System.out.println("City with max: "+cityWithMax);
		return cityWithMax;
	}
	
	protected static int getAproxCountyNr(ArrayList<String> nv) {
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
		 
		 int max = 0,max2=0;
		 String cityWithMax = "";
		 for (Map.Entry<String,Integer> entry : app.entrySet())  {
	            if(max < entry.getValue()) {
	            	max = entry.getValue();
	            	cityWithMax = entry.getKey();
	            }
	            if(max2 < entry.getValue() && max2<max) {
	            	max2 = entry.getValue();
	            }
	    } 
		 
		//System.out.println("City with max: "+cityWithMax);
		return max;	
	}
	
	
	
	protected static int getAccuracy(int n, ArrayList<Place> givenList) {
		int acc = 0;
		ArrayList<Place> neededList = new ArrayList<Place>();
		Random rand = new Random();
		for(int i=0; i<100; i++) {
			int randPlace = rand.nextInt(givenList.size());
			neededList.add(givenList.get(randPlace));
		}
		
		for(int i=0; i<neededList.size(); i++) {
			String trueCounty = neededList.get(i).getCounty();
			/*String aproxCounty = aproxCounty(calculateNV(givenList, neededList.get(i), n));
			if(trueCounty == aproxCounty) {
				acc++;
			}
			*/
		}
		System.out.println("Acc for "+n+" ="+acc);
		return acc;
	}
	
	protected static void sortAcc() {
		ArrayList<Integer> accArray = new ArrayList<Integer>();
		//if()
	}
}
