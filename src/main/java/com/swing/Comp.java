package com.swing;

import javax.swing.*;
import java.awt.*;

public class Comp extends JFrame
{
    Comp()
    {
        super("Пример использования JToolBar");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JTextArea textArea = new JTextArea(5, 20);
        getContentPane().add(new JScrollPane(textArea));

        String[] elements = new String[] {"Вася", "Петя",
                "<html><font size = +1 color = yellow>Иван</font>"};
        JComboBox combo = new JComboBox(elements);
        combo.setSelectedIndex(1);
        getContentPane().add(combo, BorderLayout.SOUTH);

        JToolBar toolBar = new JToolBar("Инструментальная панель");
        toolBar.add(new JButton("Кнопка 1"));
        toolBar.add(new JButton("Кнопка 2"));
        toolBar.addSeparator();
        toolBar.add(new JButton("Кнопка 3"));
        getContentPane().add(toolBar, BorderLayout.NORTH);
        pack();
//        setVisible(true);
        /////////////////////////////////////////////////////////


        setSize(200,200);
        setVisible(true);
    }
    public static void main(String[] args)
    {
        Comp c = new Comp();
    }
}
