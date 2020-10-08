package com.test.panel;

import com.test.date.DateTextField;
import com.test.action_listener.ActionListenerDescription;
import com.test.action_listener.ActionListenerFind;
import com.test.editor.ButtonEditEditor;
import com.test.model.MyTableModel;
import com.test.model.ProjectsDto;
import com.test.renderer.ButtonEditRenderer;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;


public class ProjectsPanel extends JPanel {

    private JTextField textFieldFrom;
    private JTextField textFieldTo;
    private JLabel from;
    private JLabel to;
    private JButton find;
    private JTable projectsData;
    private JButton edit;
    private JButton delete;
    private JButton description;
    private JLabel footer;
    private JPanel northPanel;
    private Box contents;
    private JPanel header;
    private JPanel filter;
    private JButton add;
    private JButton refresh;
    private JTable table;
    private JPanel footerPanel;

    public ProjectsPanel(){
//        String[] columnNames ={"projectId","dateAdded","countOfDevelopers", "edit", "delete", "description"};
//        Object[][] data = {{"1","12-03-2018", "1","edit","delete","description"}
//                ,{"1","12-03-2018", "1","edit","delete","description"}
//                ,{"1","12-03-2018", "1","edit","delete","description"}
//        };

        northPanel = new JPanel();
        header = new JPanel();
        filter = new JPanel();
        add = new JButton("Add");
        refresh = new JButton("Refresh");
        footerPanel = new JPanel();
        edit = new JButton();
        delete = new JButton();
        delete.addActionListener(new ActionListenerDescription());
        description = new JButton();
        description.addActionListener(new ActionListenerDescription());

        MyTableModel model = new MyTableModel();

        table = new JTable();
        table.setModel(model);
        
        table.getColumn("edit").setCellRenderer(new ButtonEditRenderer());
        table.getColumn("edit").setCellEditor(new ButtonEditEditor(new JCheckBox(), edit));

        table.getColumn("delete").setCellRenderer(new ButtonEditRenderer());
        table.getColumn("description").setCellRenderer(new ButtonEditRenderer());


            table.getColumn("delete").setCellEditor(new ButtonEditEditor(new JCheckBox(),delete));
            table.getColumn("description").setCellEditor(new ButtonEditEditor(new JCheckBox(), description));

        JTableButtonMouseListener jTableButtonMouseListener = new JTableButtonMouseListener(table);
                contents = new Box(BoxLayout.Y_AXIS);
        contents.add(new JScrollPane(table));

        footer = new JLabel("2020");

        footerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        footerPanel.add(footer);

        setLayout(new BorderLayout());
        northPanel.setLayout(new BorderLayout());

        header.setLayout(new FlowLayout(FlowLayout.RIGHT));
        header.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));

        from = new JLabel(" Filter from ");
        textFieldFrom = new DateTextField();
        to = new JLabel(" to ");
        textFieldTo = new DateTextField();
        find = new JButton("Find");
        find.addActionListener(new ActionListenerFind(textFieldFrom, textFieldTo));

        filter.setLayout(new FlowLayout(FlowLayout.LEFT));
        filter.add(from);
        filter.add(textFieldFrom);
        filter.add(to);
        filter.add(textFieldTo);
        filter.add(find);

        header.add(add);
        header.add(refresh);

//        table.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        northPanel.add(header, BorderLayout.NORTH);
        northPanel.add(filter, BorderLayout.WEST);

        add(contents, BorderLayout.CENTER);
        add(northPanel,BorderLayout.NORTH);
        add(footerPanel, BorderLayout.SOUTH);
        add_row();
    }


    public void add_row(){
        ArrayList<ProjectsDto> obj = createObj();
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

        Object[] row = new Object[6];
        for (int i = 0; i < obj.size(); i++) {

            row[0] = obj.get(i).getProjectId();
            row[1] = stringFromLocalDate(obj.get(i).getDateAdded());
            row[2] = obj.get(i).getCountOfDevelopers();
            row[3] = "edit";
            row[4] = "delete";
            row[5] = "description";
            tableModel.addRow(row);
        }

    }
    public ArrayList<ProjectsDto> createObj(){
        ArrayList<ProjectsDto> projectsDtos = new ArrayList<>();
        projectsDtos.add(new ProjectsDto(1,"Hello0",localDateFromString("12-03-2018"), 1));
        projectsDtos.add(new ProjectsDto(2,"Hello1",localDateFromString("13-03-2016"), 5));
        projectsDtos.add(new ProjectsDto(3,"Hello2",localDateFromString("14-07-2018"), 7));
        projectsDtos.add(new ProjectsDto(4,"Hello2",localDateFromString("18-07-2018"), 7));
        return projectsDtos;
    }


    public LocalDate localDateFromString(String dateS){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        formatter = formatter.withLocale(Locale.ENGLISH);  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
        LocalDate date = LocalDate.parse(dateS, formatter);
        return date;
    }
    public String stringFromLocalDate(LocalDate date){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedString = date.format(formatter);
        return formattedString;
    }

    private static class JTableButtonMouseListener extends MouseAdapter {
        private final JTable table;

        public JTableButtonMouseListener(JTable table) {
            this.table = table;
        }

        public void mouseClicked(MouseEvent e) {
            int column = table.getColumnModel().getColumnIndexAtX(e.getX()); // get the coloum of the button
            int row    = e.getY()/table.getRowHeight(); //get the row of the button

            /*Checking the row or column is valid or not*/
            if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0) {
                Object value = table.getValueAt(row, column);
                if (value instanceof JButton) {
                    /*perform a click event*/
                    ((JButton)value).doClick();
                }
            }
        }
    }

}
