import lejos.nxt.*;
import lejos.robotics.Touch;
public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Ronnie's Robot");
		
		Touch touch = new TouchSensor(SensorPort.S1);
		while(!touch.isPressed()){
			
		}
		Button.ENTER.waitForPress();
	}

}
