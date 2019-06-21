package uet.oop.bomberman.entities.character.enemy.ai;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.Game;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.entities.character.enemy.Enemy;

import java.util.Random;

public class AIMedium extends AI {
    Bomber _bomber;
    Enemy _e;
    public AIMedium(Bomber bomber, Enemy e) {
        _bomber = bomber;
        _e = e;
    }

    @Override
    public int calculateDirection() {
        // TODO: cài đặt thuật toán tìm đường đi
        int slower = random.nextInt(20);
        int faster = random.nextInt(20);

        _e.set_speed(Game.BOMBERSPEED - slower/100 + faster/100);
        if (_bomber == null)
            return random.nextInt(4);

        int vertical = random.nextInt(3);

        if (vertical == 0) {
            int v = calculateRowDirection();
            if (v != -1)
                return v;
            else
                return calculateColDirection();

        } else if (vertical == 1){
            int h = calculateColDirection();

            if (h != -1)
                return h;
            else
                return calculateRowDirection();
        } else {
            return random.nextInt(4);
        }
    }

    protected int calculateColDirection() {
        if (_bomber.getXTile() < _e.getXTile())
            return 3;
        else if (_bomber.getXTile() > _e.getXTile())
            return 1;

        return -1;
    }

    protected int calculateRowDirection() {
        if (_bomber.getYTile() < _e.getYTile())
            return 0;
        else if (_bomber.getYTile() > _e.getYTile())
            return 2;
        return -1;
    }
}
