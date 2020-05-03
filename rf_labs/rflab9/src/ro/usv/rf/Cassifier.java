package ro.usv.rf;

import java.util.ArrayList;

public class Cassifier {
	ArrayList<Entry> patterns;
	Entry k1, k2;
	public Cassifier(ArrayList<Entry> patterns) {
		k1 = patterns.get(0);
		k1.setPredictedClass(1);
		k2 = patterns.get(1);
		k2.setPredictedClass(2);
		this.patterns = patterns;
		
		for(int i=2; i<patterns.size(); i++) {
			if(calculateEuclidianDistance(k1, patterns.get(i)) < calculateEuclidianDistance(k2, patterns.get(i))) {
				patterns.get(i).setPredictedClass(k1.getPredictedClass());
			}
			else {
				patterns.get(i).setPredictedClass(k2.getPredictedClass());
			}
		}
		
		
	}
	
	public void iterate() {
		Entry g1 = new Entry();
		double g1x=0,g1y=0,g2x=0,g2y=0;
		Entry g2 = new Entry();
		for(int i=0; i<this.patterns.size(); i++) {
			if(this.patterns.get(i).getPredictedClass()==1) {
				
			}
		}
	}
	protected static double calculateEuclidianDistance(Entry a, Entry b) {
		double sum = 0.0;
		sum = Math.pow(a.getFeature(0) - b.getFeature(0), 2)+Math.pow(a.getFeature(1) - b.getFeature(1), 2);
		return Math.sqrt(sum);
	}
	public void func(ArrayList<Entry> patterns) {
		
	}
	
	public void showEntries() {
		for(int i=0; i<patterns.size(); i++) {
			System.out.println(patterns.get(i).displayEntry());
		}
	}
		
}
