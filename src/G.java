import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class G extends PApplet {
	public static G gf;
	Car car;
	List<Monster> monsters = new ArrayList<Monster>();
	
	@Override
	public void setup() {
		gf = this;
		size(1300, 800);
		car = new Car(new PVector(getWidth()/2, getHeight()/2));
        Monster firstMonster = new Monster(new PVector(getWidth()/2, getHeight()/2 - 200));
        firstMonster.setVelocity(new PVector(0.1f, 0f));
		monsters.add(firstMonster);
	}
	
	Integer round = 1;
	@Override
	public synchronized void draw() {
		background(255);
		text(Float.toString(mouseX) + ", " + Float.toString(mouseY),
														width - 150, height - 30);
		car.update();
		
		if(monsters.size() > 0) {
			for(Monster monster : monsters) {
				monster.update();
				monster.chase(car.getLocation());
				if(car.getLocation().x > monster.getLocation().x && 
						car.getLocation().y > monster.getLocation().y &&
						car.getLocation().x < monster.getLocation().x + monster.getWidth() &&
						car.getLocation().y < monster.getLocation().y + monster.getHeight()) {
					monsters = new ArrayList<>();
					round = 1;
				}
			}
		} else {
			for(int i = 0; i < round; i++) {
				switch((int) random(0, 4)) {
				case 0:
					monsters.add(new Monster(new PVector(0f, 0f)));
					break;
				case 1:
					monsters.add(new Monster(new PVector(width - 100f, 0f)));
					break;
				case 2:
					monsters.add(  new Monster(new PVector(0f, height - 100f))  );
					break;
				case 3:
					monsters.add(new Monster(new PVector( - 100f, height - 100f)));
					break;
				default: break;
				}
			}
			round++;
		}
	}
	
	@Override
	public synchronized void mouseClicked() {
        System.out.println("clicking: " + mouseX + ", " + mouseY);
        System.out.println("monsters are : " + String.join(" ", monsters.stream().map(x -> x.toString()).collect(
                Collectors.toList())));
        monsters.removeIf(monster -> mouseX > monster.getLocation().x &&
                mouseY > monster.getLocation().y &&
                mouseX < monster.getLocation().x + monster.getWidth() &&
                mouseY < monster.getLocation().y + monster.getHeight() + 100);
	}


}
