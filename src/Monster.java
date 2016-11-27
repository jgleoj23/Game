import processing.core.PImage;
import processing.core.PVector;


public class Monster extends Matter {
	private PImage img = G.gf.loadImage("resources/readfile.png");
	
	{
		setMass(1f);
	}
	public Monster() {}
	public Monster(PVector location) {
		setLocation(location);
	}



	public void display() {
		G.gf.image(img, getLocation().x, getLocation().y);
	}
	
	@Override
	public void update() {
		if(getLocation().x > G.gf.width) {
			getVelocity().x = -.1f;
		}
		if(getLocation().x < 0) getVelocity().x = 1f;
		if(getLocation().y > G.gf.height) getVelocity().y = -.1f;
		if(getLocation().y < 0) getVelocity().y = .1f;
		
		super.update();
	}
	
	public void chase(PVector target) {
		PVector force = PVector.sub(target, getLocation());
		force.normalize();
		force.mult(.1f);
		
		force(force);
	}
	
	
	
	public int getWidth() {
		return img.width;
	}
	public int getHeight() {
		return img.height;
	}
}
