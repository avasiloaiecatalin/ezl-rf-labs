package ro.usv.rf;

import java.util.Comparator;

public class PlacesComparator implements Comparator<Place> {
	@Override
	public int compare(Place o1, Place o2) {
		if(o1.getDistanceToP() < o2.getDistanceToP())
			return -1;
		if(o1.getDistanceToP() > o2.getDistanceToP())
			return 1;
		return 0;
	}
}
