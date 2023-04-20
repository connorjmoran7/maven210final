package edu.guilford.basicwordle;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import javax.swing.JFrame;

public class BasicWordle {

    public static void main(String[] args) throws FileNotFoundException {

        JFrame gameWindow = new JFrame("Wordle!");
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setPreferredSize(new Dimension(1400, 650));

        GamePanel game = new GamePanel();
        gameWindow.getContentPane().add(game, BorderLayout.LINE_START);

        gameWindow.pack();
        gameWindow.setVisible(true);

    }

}
