package uet.oop.bomberman.gui.menu;

import uet.oop.bomberman.gui.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;


public class Game extends JMenu {

    public Frame _frame;

    public Game(Frame frame) {
        super("Game");
        _frame = frame;

        JMenuItem newGame = new JMenuItem("New Game");
        KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK);
        newGame.setAccelerator(key);
        newGame.addActionListener(new MenuActionListener(frame));
        add(newGame);

        JMenuItem pause = new JMenuItem("Pause Game");
        KeyStroke key1 = KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK);
        pause.setAccelerator(key1);
        pause.addActionListener(new MenuActionListener(frame));
        add(pause);

        JMenuItem resume = new JMenuItem("Resume Game");
        KeyStroke key2 = KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK);
        resume.setAccelerator(key2);
        resume.addActionListener(new MenuActionListener(frame));
        add(resume);
    }

    class MenuActionListener implements ActionListener {
        public Frame _frame;
        public KeyStroke _key;
        public MenuActionListener(Frame frame) {
            _frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent event) {

            if(event.getActionCommand().equals("New Game")) {
                _frame.newGame();
            }
            if(event.getActionCommand().equals("Pause Game")) {
                _frame.pauseGame();
            }
            if(event.getActionCommand().equals("Resume Game")) {
                _frame.resumeGame();
            }
        }
    }

}
