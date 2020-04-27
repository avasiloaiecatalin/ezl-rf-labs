package ro.usv.rf;

import java.util.ArrayList;
import java.util.Comparator;

public class Entry{
	ArrayList<Double> features;
	double fi;
	double classFactor;
	public double getClassFactor() {
		return classFactor;
	}

	public void setClassFactor(double classFactor) {
		this.classFactor = classFactor;
	}

	public double getFi() {
		return fi;
	}

	public void setFi(double fi) {
		this.fi = fi;
	}

	public int getPredictedClass() {
		return predictedClass;
	}

	public void setPredictedClass(int predictedClass) {
		this.predictedClass = predictedClass;
	}

	int predictedClass;
	
	public Entry() {
		this.features = new ArrayList<Double>();
		this.fi = (-1.0)*Double.MIN_VALUE;
		this.predictedClass = 0;
	}
	
	public Entry(double x, double y) {
		this.features = new ArrayList<Double>();
		addFeature(x); addFeature(y);
		this.fi = Double.NEGATIVE_INFINITY;
		this.predictedClass = 0;
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
