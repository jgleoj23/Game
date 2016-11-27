import processing.core.PVector;

public abstract class Matter {
	private Float mass;
	private PVector velocity = new PVector();
	private PVector location;
	
	public Matter() {}
	public Matter(Float mass, PVector location) {
		this.mass = mass;
		this.location = location;
	}

	public void update() {
		location.add(velocity);
		
		display();
	}

	public abstract void display();
	
	public void force(PVector force) {
		velocity.add(PVector.div(force, mass));
	}

	
	
	public Float getMass() {
		return mass;
	}
	/**
	 * 
	 * @param mass > 0
	 * @throws RuntimeException mass must be greater than 0 so this is thrown if(the mass <= 0)
	 */
	public void setMass(Float mass) throws RuntimeException {
		if(mass <= 0) throw new RuntimeException("mass must be greater than 0");
		
		this.mass = mass;
	}

	public PVector getVelocity() {
		return velocity;
	}
	public void setVelocity(PVector velocity) {
		this.velocity = velocity;
	}

	public PVector getLocation() {
		return location;
	}
	public void setLocation(PVector location) {
		this.location = location;
	}
}
