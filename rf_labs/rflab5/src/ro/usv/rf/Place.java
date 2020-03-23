package ro.usv.rf;

public class Place implements Comparable<Place>{
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
	public int compareTo(Place o) {
		if(this.getDistanceToP() - o.getDistanceToP() == 0)
			return 0;
		if(this.getDistanceToP() - o.getDistanceToP() < 0)
			return -1;
		else
			return 1;
	}
}
