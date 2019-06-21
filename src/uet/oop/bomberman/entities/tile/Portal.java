package uet.oop.bomberman.entities.tile;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.bomb.Flame;
import uet.oop.bomberman.entities.bomb.FlameSegment;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.Board;
import uet.oop.bomberman.sound.Sound;

public class Portal extends Tile {

    private Board _board;

	public Portal(int x, int y,Board board, Sprite sprite) {
		super(x, y, sprite);
		_board = board;
	}
	
	@Override
	public boolean collide(Entity e) {
		// TODO: xử lý khi Bomber đi vào
        /**
         * @VA Done
         */
		if (e instanceof Bomber){
            if (_board.detectNoEnemies()){
                if (e.getXTile() == getX() && e.getYTile() == getY()){
					Sound.playPass();
                    _board.nextLevel();
                }
            }
            return true;
        }
        if (e instanceof Flame || e instanceof FlameSegment) return true;
		return false;
	}

}
