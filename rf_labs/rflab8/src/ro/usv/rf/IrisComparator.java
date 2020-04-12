package ro.usv.rf;

import java.util.Comparator;

public class IrisComparator implements Comparator<Iris> {
	@Override
	public int compare(Iris o1, Iris o2) {
		if(o1.getClassFactor() < o2.getClassFactor())
			return -1;
		if(o1.getClassFactor() > o2.getClassFactor())
			return 1;
		return 0;
	}
}
