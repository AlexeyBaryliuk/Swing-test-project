package com.test.model;

import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel {


    public MyTableModel() {
        super(new Object[][]{},
                new String[]{
                        "projectId","dateAdded","countOfDevelopers", "edit", "delete", "description"
                });
    }
    Class[] types = new Class[]{
            Integer.class
            , String.class
            , String.class
            , Boolean.class
            , Boolean.class
            , Boolean.class
    };
    boolean[] canEdit = new boolean[]{
            false, true, false, true, true, true
    };

    public Class getColumnClass(int columnIndex) {
        return types[columnIndex];
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
    }

}
