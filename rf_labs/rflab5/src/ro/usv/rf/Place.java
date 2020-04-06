package ro.usv.rf;

import java.util.Comparator;

public class Place implements Comparator<Place>{
	private String county;
	private Double x;
	private Double y;
	private Double distanceToP;
	public Place() {
		//
	}
	
	public Place(String x, String y, String county) {
		setX(x);
		setY(y);
		setCounty(county);
		setDistanceToP(-1.0);
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public Double getX() {
		return x;
	}
	public void setX(String x) {
		this.x = Double.valueOf(x);
	}
	public Double getY() {
		return y;
	}
	public void setY(String y) {
		this.y = Double.valueOf(y);
	}

	public Double getDistanceToP() {
		return distanceToP;
	}

	public void setDistanceToP(Double distanceToP) {
		this.distanceToP = distanceToP;
	}


	@Override
	public int compare(Place o1, Place o2) {
		if(o1.getDistanceToP() > o2.getDistanceToP())
			return 1;
		if(o1.getDistanceToP() < o2.getDistanceToP())
			return -1;
		else
			return 0;
	}
}
