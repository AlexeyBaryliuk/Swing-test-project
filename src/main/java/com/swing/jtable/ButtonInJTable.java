package com.swing.jtable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ButtonInJTable extends JFrame {

    private JPanel topPanel;
    private JTable table;
    private JScrollPane scrollPane;
    private String[] columnNames;
    private String[][] dataValues;

    JButton button = new JButton();


    public ButtonInJTable() {

        setTitle("Button in JTable Cell");
        setSize(300, 300);

        topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        getContentPane().add(topPanel);

        columnNames = new String[]{"ProjectId", "DateAdded", "Count of developers", "Edit", "Delete", "Description"};
        dataValues = new String[][]{{"1", "2019-03-12", "2",},
                {"2", "2018-04-20","1",},
                {"3", "2017-05-25", "1",}
        };

        TableModel model = new myTableModel("owntable");

        table = new JTable();
        table.setModel(model);
        table.getColumn("Edit").setCellRenderer(new ButtonEditRenderer());
        table.getColumn("Edit").setCellEditor(new ButtonEditEditor(new JCheckBox()));

        scrollPane = new JScrollPane(table);
        topPanel.add(scrollPane, BorderLayout.CENTER);

        button.addActionListener(

                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {

                        JOptionPane.showMessageDialog(null, "Button Clicked in JTable Cell");
                    }
                }
        );
    }

        class ButtonEditEditor extends DefaultCellEditor {

            private String label;
            public ButtonEditEditor(JCheckBox checkBox) {
                super(checkBox);

            }

            public Component getTableCellEditorComponent(JTable table
                                                        , Object value
                                                        , boolean isSelected
                                                        , int row
                                                        , int column) {

                label = (value == null) ? "hello" : value.toString();
                button.setText(label);
                return button;

            }

            public Object getCellEditorValue() {
                return new String(label);
            }

        }

        public class myTableModel extends DefaultTableModel {

            String dat;
//            JButton button = new JButton("");

            public myTableModel(String tname) {

                super(dataValues, columnNames);
                dat = tname;
            }

            public boolean isCellEditable(int row, int cols) {

                if (dat.equals("owntable")) {
                    if (cols == 0) {
                        return false;
                    }
                }

                return true;
            }

        }

        public static void main(String args[]) {

            ButtonInJTable mainFrame = new ButtonInJTable();
            mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            mainFrame.setVisible(true);

        }

    }

