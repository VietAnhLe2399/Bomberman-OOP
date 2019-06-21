package uet.oop.bomberman.entities.bomb;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.character.Character;
import uet.oop.bomberman.graphics.Screen;

public class Flame extends Entity {

    protected Board _board;
    protected int _direction;
    private int _radius;
    protected int xOrigin, yOrigin;
    protected FlameSegment[] _flameSegments = new FlameSegment[0];

    /**
     * @param x         hoành độ bắt đầu của Flame
     * @param y         tung độ bắt đầu của Flame
     * @param direction là hướng của Flame
     * @param radius    độ dài cực đại của Flame
     */

    /**
     * @VA Done, Tested
     */

    public Flame(int x, int y, int direction, int radius, Board board) {
        xOrigin = x;
        yOrigin = y;
        _x = x;
        _y = y;
        _direction = direction;
        _radius = radius;
        _board = board;
        createFlameSegments();
    }

    /**
     * Tạo các FlameSegment, mỗi segment ứng một đơn vị độ dài
     */
    private void createFlameSegments() {
        /**
         * tính toán độ dài Flame, tương ứng với số lượng segment
         */
        _flameSegments = new FlameSegment[calculatePermitedDistance()];

        /**
         * biến last dùng để đánh dấu cho segment cuối cùng
         */
        boolean last;
        int leftright = (int) _x;
        int updown = (int) _y;
        for (int i = 0; i < _flameSegments.length; i++) {
            if (i == _flameSegments.length - 1)
                last = true;
            else
                last = false;

            switch (_direction) {
                case 0:
                    updown--;
                    break;
                case 1:
                    leftright++;
                    break;
                case 2:
                    updown++;
                    break;
                case 3:
                    leftright--;
                    break;
            }
            _flameSegments[i] = new FlameSegment(leftright, updown, _direction, last);
        }

        // TODO: tạo các segment dưới đây

    }

    /**
     * Tính toán độ dài của Flame, nếu gặp vật cản là Brick/Wall, độ dài sẽ bị cắt ngắn
     *
     * @return
     */
    private int calculatePermitedDistance() {
        // TODO: thực hiện tính toán độ dài của Flame
        /**
         * @VA Done
         */
        int radius = 0;
        int leftright = (int) _x;
        int updown = (int) _y;
        while (radius < _radius) {
            if (_direction == 0) updown--;
            if (_direction == 1) leftright++;
            if (_direction == 2) updown++;
            if (_direction == 3) leftright--;

            Entity entity = _board.getEntity(leftright, updown, null);

            if (entity instanceof Character) ++radius;

            if (entity.collide(this) == false)
                break;
            ++radius;
        }
        return radius;
    }

    public FlameSegment flameSegmentAt(int x, int y) {
        for (int i = 0; i < _flameSegments.length; i++) {
            if (_flameSegments[i].getX() == x && _flameSegments[i].getY() == y)
                return _flameSegments[i];
        }
        return null;
    }

    @Override
    public void update() {
    }

    @Override
    public void render(Screen screen) {
        for (int i = 0; i < _flameSegments.length; i++) {
            _flameSegments[i].render(screen);
        }
    }

    @Override
    public boolean collide(Entity e) {
        // TODO: xử lý va chạm với Bomber, Enemy. Chú ý đối tượng này có vị trí chính là vị trí của Bomb đã nổ
        return true;
    }
}
