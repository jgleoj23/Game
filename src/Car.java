import processing.core.PVector;

public class Car extends Point {
	
	{ setMass(1f); }
	
	public Car() {}
	public Car(PVector location) {
		setLocation(location);
	}

	
	@Override
	public void update() {
		PVector mouse = new PVector(G.gf.mouseX, G.gf.mouseY);
		PVector force = PVector.sub(mouse, getLocation());
		force.normalize();
		force.mult(.2f);
		
		force(force);
		
		if(getLocation().x > G.gf.width) getVelocity().x = -.1f;
		if(getLocation().x < 0) getVelocity().x = .1f;
		if(getLocation().y > G.gf.height) getVelocity().y = -.1f;
		if(getLocation().y < 0) getVelocity().y = .1f;
		
		super.update();
	}

}
