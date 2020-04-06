package ro.usv.rf;

import java.util.ArrayList;
import java.util.Comparator;

public class Place{
	ArrayList<Double> features;
	String placeClass;
	double fi;
	public double getFi() {
		return fi;
	}

	public void setFi(double fi) {
		this.fi = fi;
	}

	public String getPredictedClass() {
		return predictedClass;
	}

	public void setPredictedClass(String predictedClass) {
		this.predictedClass = predictedClass;
	}

	String predictedClass;
	
	public Place() {
		this.features = new ArrayList<Double>();
		this.fi = (-1.0)*Double.MIN_VALUE;
		this.predictedClass = "Ceva";
	}
	
	public Place(double x, double y) {
		this.features = new ArrayList<Double>();
		addFeature(x); addFeature(y);
		this.fi = Double.NEGATIVE_INFINITY;
		this.predictedClass = "Ceva";
	}

	public String getPlaceClass() {
		return placeClass;
	}

	public void setPlaceClass(String placeClass) {
		this.placeClass = placeClass;
	}

	public ArrayList<Double> getFeatures() {
		return features;
	}

	public void setFeatures(ArrayList<Double> features) {
		this.features = features;
	}
	
	public double getFeature(int x) {
		return this.features.get(x);
	}
	
	public void addFeature(double x) {
		this.features.add(x);
	}
	
	public String displayFeatures() {
		String display = "( ";
		for(double d: this.features) {
			display += (d+" ");
		}
		display += ")";
		return display;
	}
}
