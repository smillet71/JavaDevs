package stm.dev.gui;

import processing.core.PApplet;
import processing.core.PFont;
import stm.dev.game.states.GameRunningState;
import controlP5.*;

/**
 * 
 * @author smill
 *
 */
public class GameWindow extends PApplet {


	//
	private GameRunningState GRS = null;
	private ControlP5 cp5 = null;

	/**
	 * 
	 * @param grs
	 */
	public GameWindow(GameRunningState grs) {
		super();
		//
		GRS = grs;
		//
		String[] args = {""};
		PApplet.runSketch(args, this);
	}

	/**
	 * 
	 */
	public void enable() {
		//
		//
		surface.setVisible(true);
	}

	/**
	 * 
	 */
	public void disable() {
		//
		surface.setVisible(false);
	}

	//
	public void settings(){
		fullScreen(1);
	}

	//
	public void setup(){
		//
		cp5 = new ControlP5(this);
		PFont font = createFont("arial",20);
		//
		Textfield tf = cp5.addTextfield("input")
		.setPosition((width-500)/2,height-50)
		.setSize(500,40)
		.setFont(font)
		.setFocus(true)
		.setColor(color(255,0,0))
		;
		tf.getCaptionLabel().align(ControlP5.LEFT_OUTSIDE, ControlP5.CENTER);
	}

	//
	public void draw(){
		background(0);
		ellipse(width/2,height/2,second(),second());
	}

	/**
	 * 
	 */
	@Override
	public void mouseClicked() {
		//
		GRS.goToMainMenu();
	}
	
	/**
	 * 
	 * @param text
	 */
	public void input(String text) {
		System.out.println(text);
	}

}
