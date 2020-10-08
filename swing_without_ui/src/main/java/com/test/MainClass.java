package com.test;

import com.test.panel.DevelopmentTeam;

import javax.swing.*;

public class MainClass {
    public static void main(String[] args) {
        JFrame frame = new DevelopmentTeam();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(600,400);
    }
}
