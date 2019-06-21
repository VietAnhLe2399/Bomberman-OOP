package uet.oop.bomberman.gui.menu;

import uet.oop.bomberman.gui.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Options extends JMenu {

    Frame _frame;

    public Options(Frame frame) {
        super("Level");

        _frame = frame;

        JMenuItem level1 = new JMenuItem("Level 1");
        KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_1, KeyEvent.CTRL_DOWN_MASK);
        level1.setAccelerator(key);
        level1.addActionListener(new MenuActionListener(frame));
        add(level1);

        JMenuItem level2 = new JMenuItem("Level 2");
        KeyStroke key2 = KeyStroke.getKeyStroke(KeyEvent.VK_2, KeyEvent.CTRL_DOWN_MASK);
        level2.setAccelerator(key2);
        level2.addActionListener(new MenuActionListener(frame));
        add(level2);

        JMenuItem level3 = new JMenuItem("Level 3");
        KeyStroke key3 = KeyStroke.getKeyStroke(KeyEvent.VK_3, KeyEvent.CTRL_DOWN_MASK);
        level3.setAccelerator(key3);
        level3.addActionListener(new MenuActionListener(frame));
        add(level3);

        JMenuItem level4 = new JMenuItem("Level 4");
        KeyStroke key4 = KeyStroke.getKeyStroke(KeyEvent.VK_4, KeyEvent.CTRL_DOWN_MASK);
        level4.setAccelerator(key4);
        level4.addActionListener(new MenuActionListener(frame));
        add(level4);

        JMenuItem level5 = new JMenuItem("Level 5");
        KeyStroke key5 = KeyStroke.getKeyStroke(KeyEvent.VK_5, KeyEvent.CTRL_DOWN_MASK);
        level5.setAccelerator(key5);
        level5.addActionListener(new MenuActionListener(frame));
        add(level5);
    }

    class MenuActionListener implements ActionListener {
        public Frame _frame;

        public MenuActionListener(Frame frame) {
            _frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand().equals("Level 1")) {
                _frame.changeLevel(1);
            }
            if (e.getActionCommand().equals("Level 2")) {
                _frame.changeLevel(2);
            }
            if (e.getActionCommand().equals("Level 3")) {
                _frame.changeLevel(3);
            }
            if (e.getActionCommand().equals("Level 4")) {
                _frame.changeLevel(4);
            }
            if (e.getActionCommand().equals("Level 5")) {
                _frame.changeLevel(5);
            }
        }
    }
}
