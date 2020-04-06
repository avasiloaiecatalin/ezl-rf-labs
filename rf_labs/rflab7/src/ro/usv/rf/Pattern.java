package ro.usv.rf;

import java.util.ArrayList;

public class Pattern {
	ArrayList<Double> features;
	double patternClass;
	double fi;
	public double getFi() {
		return fi;
	}

	public void setFi(double fi) {
		this.fi = fi;
	}

	public double getPredictedClass() {
		return predictedClass;
	}

	public void setPredictedClass(double predictedClass) {
		this.predictedClass = predictedClass;
	}

	double predictedClass;
	
	public Pattern() {
		this.features = new ArrayList<Double>();
		this.fi = (-1.0)*Double.MIN_VALUE;
		this.predictedClass = -1.0;
	}
	
	public Pattern(double x, double y) {
		this.features = new ArrayList<Double>();
		addFeature(x); addFeature(y);
		this.fi = Double.NEGATIVE_INFINITY;
		this.predictedClass = -1.0;
	}

	public double getPatternClass() {
		return patternClass;
	}

	public void setPatternClass(double patternClass) {
		this.patternClass = patternClass;
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
