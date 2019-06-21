package uet.oop.bomberman;

import uet.oop.bomberman.gui.Frame;

public class BombermanGame {
	
	public static void main(String[] args) {
		try{
			new Frame();
		} catch (Exception e){
//			e.printStackTrace();
			System.exit(0);
		}
	}
}
