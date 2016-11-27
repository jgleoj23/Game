import processing.core.PVector;


public class Point extends Matter {
	
	public Point() {}
	public Point(Float mass, PVector location) { super(mass, location); }

	
	@Override
	public void display() {
		G.gf.stroke(0);
	    G.gf.fill(175);
	    G.gf.pushMatrix();
	    G.gf.ellipse(getLocation().x, getLocation().y, 10, 10);
	    G.gf.popMatrix();
	}
}
