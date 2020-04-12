package ro.usv.rf;

import java.util.ArrayList;
import java.util.Comparator;

public class Iris implements Comparator<Iris>{
	ArrayList<Double> features;
	String irisClass;
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

	public String getPredictedClass() {
		return predictedClass;
	}

	public void setPredictedClass(String predictedClass) {
		this.predictedClass = predictedClass;
	}

	String predictedClass;
	
	public Iris() {
		this.features = new ArrayList<Double>();
		this.fi = (-1.0)*Double.MIN_VALUE;
		this.predictedClass = "Ceva";
	}
	
	public Iris(double x, double y, double z, double a) {
		this.features = new ArrayList<Double>();
		addFeature(x); addFeature(y); addFeature(z); addFeature(a);
		this.fi = Double.NEGATIVE_INFINITY;
		this.predictedClass = "Ceva";
	}

	public String getIrisClass() {
		return irisClass;
	}

	public void setIrisClass(String placeClass) {
		this.irisClass = placeClass;
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

	@Override
	public int compare(Iris o1, Iris o2) {
		if(o1.getClassFactor() < o2.getClassFactor())
			return -1;
		if(o1.getClassFactor() > o2.getClassFactor())
			return 1;
		return 0;
	}
}
