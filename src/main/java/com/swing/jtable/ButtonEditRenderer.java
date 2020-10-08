package com.swing.jtable;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

 class ButtonEditRenderer extends JButton implements TableCellRenderer {

    public ButtonEditRenderer() {
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table
            , Object value
            , boolean isSelected
            , boolean hasFocus
            , int row
            , int column) {

        setText((value == null) ? "" : value.toString());
        setForeground(isSelected ? Color.blue : Color.black);
        setBackground(isSelected ? Color.darkGray : Color.white);
        return this;
    }
}
