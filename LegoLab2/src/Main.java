import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;



public class Main {

	public static boolean shouldBeDriving = true;
	public static boolean traversed = true;
	public static int direction = 1;
	public static DifferentialPilot p = new DifferentialPilot(2.25f, 5.5f, Motor.A, Motor.B);
	public static ColorSensor light = new ColorSensor(SensorPort.S1);
	
	public static void main (String args[]) {
		drive();
	}
	
	public static void drive (){
		
		while(shouldBeDriving)
		{
			p.setTravelSpeed(4);
			p.forward();
			int lightValue = light.getLightValue();
			if(lightValue > 50)
			{
				turn();
			}
			if(Button.ENTER.isPressed())
			{
				shouldBeDriving = false;
			}
		}
	}
	
	// Travel along a black line, corrects itself when it strays
	public static void turn(){
		if(direction == 1)
		{
			direction = 2;
			p.rotate(10);
			if(light.getLightValue() > 50){
				p.rotate(-20);				
			}
		}
		else if(direction == 2)
		{
			direction = 1;
			p.rotate(-10);
			if(light.getLightValue() > 50){
				p.rotate(20);				
			}
		}
	}
	
	//Move around an object of known size
	public static void traverseShape(){
		p.travel(-5);
		p.rotate(-114);
		p.travel(12);
		p.rotate(114);
		p.travel(19);
		p.rotate(100);
		p.travel(10);
		p.rotate(-114);
		traversed = true;
	}
}
