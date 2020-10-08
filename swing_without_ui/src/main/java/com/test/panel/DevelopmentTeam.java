package com.test.panel;

import com.test.panel.BarPanel;
import com.test.panel.ProjectsPanel;

import javax.swing.*;
import java.awt.*;

public class DevelopmentTeam extends JFrame {

    private JPanel parent;
    private JPanel barPanel;
    private JPanel cardPanel;
    private JPanel projectsPanel;

    private CardLayout cardLayout = new CardLayout();
    private BorderLayout borderLayout = new BorderLayout();

    public DevelopmentTeam(){

        super("Development team");
        parent = new JPanel();

        parent.setLayout(borderLayout);
        barPanel = new BarPanel();
        parent.add(barPanel,BorderLayout.NORTH);

        cardPanel = new JPanel();
        cardPanel.setLayout(cardLayout);
        parent.add(cardPanel, BorderLayout.CENTER);

        projectsPanel = new ProjectsPanel();
        parent.add(projectsPanel);

        add(parent);
    }
}
