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
	protected static ArrayList<Double> getWRow(ArrayList<Pattern> list) {
		
		ArrayList<Double> wRow = new ArrayList<Double>();
		double avg = 0.0;
		for (int j = 0; j < list.get(0).getFeatures().size(); j++) {
			for (int i = 0; i < list.size(); i++) {
				avg += list.get(i).getFeature(j);
			}
			avg /= list.size();
			wRow.add(avg);
			avg = 0.0;
		}
		double sum = 0.0;
		for(int i=0; i<wRow.size(); i++) {
			sum += Math.pow(wRow.get(i),2);
		}
		sum *= (-0.5);
		wRow.add(sum);
		return wRow;
	}
	
	protected static ArrayList<Double> getWRowForPlaces(ArrayList<Place> list) {
		//ArrayList<ArrayList<Double>> w = new ArrayList<ArrayList<Double>>();
		ArrayList<Double> wRow = new ArrayList<Double>();
		double avg = 0.0;
		for (int j = 0; j < list.get(0).getFeatures().size(); j++) {
			for (int i = 0; i < list.size(); i++) {
				avg += list.get(i).getFeature(j);
			}
			avg /= list.size();
			wRow.add(avg);
			avg = 0.0;
		}
		double sum = 0.0;
		for(int i=0; i<wRow.size(); i++) {
			sum += Math.pow(wRow.get(i),2);
		}
		sum *= (-0.5);
		wRow.add(sum);
		return wRow;
	}
	
	protected static double getFi(ArrayList<Double> wRow, Pattern p) {
		double fi = 0.0;
		ArrayList<Double> pFeatures = new ArrayList<Double>();
		pFeatures.addAll(p.getFeatures());
		if(wRow.size() != pFeatures.size()){
			pFeatures.add(1.0);
		}
		for(int i=0; i<wRow.size(); i++) {
			fi+= wRow.get(i)*pFeatures.get(i);
		}
		return fi;
	}
	
	protected static double getFiForPlace(ArrayList<Double> wRow, Place p) {
		double fi = 0.0;
		ArrayList<Double> pFeatures = new ArrayList<Double>();
		pFeatures.addAll(p.getFeatures());
		if(wRow.size() != pFeatures.size()){
			pFeatures.add(1.0);
		}
		for(int i=0; i<wRow.size(); i++) {
			fi+= wRow.get(i)*pFeatures.get(i);
		}
		return fi;
	}
}
