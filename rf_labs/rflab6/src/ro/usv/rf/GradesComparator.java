package ro.usv.rf;

import java.util.Comparator;

public class GradesComparator implements Comparator<Grade> {
	@Override
	public int compare(Grade o1, Grade o2) {
		if(o1.getDifToG() > o2.getDifToG())
			return 1;
		if(o1.getDifToG() < o2.getDifToG())
			return -1;
		else
			return 0;
	}
}
