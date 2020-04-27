package ro.usv.rf;

import java.util.Comparator;

public class Grade implements Comparator<Grade>{
	private Double numeric;
	private String className;
	private Double difToG;
	
	public Grade() {
		
	}
	
	public Grade(String numeric, String className) {
		setClassName(className);
		setNumeric(numeric);
		setDifToG(-1.0);
	}

	public Double getNumeric() {
		return numeric;
	}

	public void setNumeric(String numeric) {
		this.numeric = Double.valueOf(numeric);
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Double getDifToG() {
		return difToG;
	}

	public void setDifToG(Double difToG) {
		this.difToG = difToG;
	}

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
