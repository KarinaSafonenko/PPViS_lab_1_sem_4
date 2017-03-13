package by.safonenko.bsuir.ppvis;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTable;

/**
 * Created by Admin on 10.03.2017.
 */
public class MainFrame {
    int check=0;
    JPanel jpnlAddToComboBox;
    JPanel jpnlSetAndChangeNames;
    JPanel jpnlMarkRadioButton;
    JPanel jpnlMarkCheckBoxes;
    JPanel jpnlAddToTable;
    JFrame jfrmStorageOfTasks;

    public MainFrame(){
        jfrmStorageOfTasks = new JFrame("by/safonenko/bsuir/ppvis/Widget");
        jfrmStorageOfTasks.getContentPane().setLayout(new FlowLayout());
        jfrmStorageOfTasks.setSize(900,300);
        jfrmStorageOfTasks.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CreatePanels();
        CreateAdditionToComboBox();
        CreateSettingAndChangingNames();
        CreateMarkingRadioButton();
        CreateMarkingChackBoxes();
        CreateAdditionToTable();
        AddPanels();

        jfrmStorageOfTasks.setVisible(true);
    }

    private void CreatePanels(){
        jpnlAddToComboBox = new JPanel();
        jpnlAddToComboBox.setPreferredSize(new Dimension(150,230));
        jpnlAddToComboBox.setOpaque(true);
        jpnlAddToComboBox.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        jpnlSetAndChangeNames = new JPanel();
        jpnlSetAndChangeNames.setPreferredSize(new Dimension(150,230));
        jpnlSetAndChangeNames.setOpaque(true);
        jpnlSetAndChangeNames.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        jpnlMarkRadioButton = new JPanel();
        jpnlMarkRadioButton.setPreferredSize(new Dimension(150,230));
        jpnlMarkRadioButton.setOpaque(true);
        jpnlMarkRadioButton.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        jpnlMarkCheckBoxes = new JPanel();
        jpnlMarkCheckBoxes.setPreferredSize(new Dimension(150,230));
        jpnlMarkCheckBoxes.setOpaque(true);
        jpnlMarkCheckBoxes.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        jpnlAddToTable = new JPanel();
        jpnlAddToTable.setPreferredSize(new Dimension(180,230));
        jpnlAddToTable.setOpaque(true);
        jpnlAddToTable.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        JLabel jlab1 = new JLabel("Add to ComboBox");
        JLabel jlab2 = new JLabel("Set and change names");
        JLabel jlab3 = new JLabel("Mark RadioButton");
        JLabel jlab4 = new JLabel("Mark CheckBoxes");
        JLabel jlab5 = new JLabel("Add and change columns");
        jlab5.setHorizontalTextPosition(SwingConstants.CENTER);

        jpnlAddToComboBox.add(jlab1);
        jpnlSetAndChangeNames.add(jlab2);
        jpnlMarkRadioButton.add(jlab3);
        jpnlMarkCheckBoxes.add(jlab4);
        jpnlAddToTable.add(jlab5);
    }
    private void CreateAdditionToComboBox() {
        JTextField jtfAddText = new JTextField(10);
        JComboBox jcbGetText = new JComboBox();
        jcbGetText.setEditable(true);
        JButton jbtnAddText = new JButton("Add text");

        jbtnAddText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String item = jtfAddText.getText();
                if (item == null) return;
                int i;
                int k=0;
                for (i=0; i<jcbGetText.getItemCount(); i++)
                    if(item.equals(jcbGetText.getItemAt(i))||item.equals("")) {
                        JOptionPane.showMessageDialog(jcbGetText, "Text has already existed!");
                        k++;
                    }
                if (k==0 && i == jcbGetText.getItemCount()) jcbGetText.addItem(item);
            }
        });

        jpnlAddToComboBox.add(jtfAddText);
        jpnlAddToComboBox.add(jcbGetText);
        jpnlAddToComboBox.add(jbtnAddText);

    }

    private void CreateSettingAndChangingNames(){
        JTextField jtfAddInf = new JTextField(10);
        JButton jbtnSetName = new JButton("Give it a name");
        JButton jbtnGetName = new JButton("Empty");

        jbtnSetName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jbtnGetName.setText(jtfAddInf.getText());
            }
        });



        jbtnGetName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String Name = jbtnSetName.getText();
                jbtnSetName.setText(jbtnGetName.getText());
                jbtnGetName.setText(Name);
            }
        });

        jpnlSetAndChangeNames.add(jtfAddInf);
        jpnlSetAndChangeNames.add(jbtnSetName);
        jpnlSetAndChangeNames.add(jbtnGetName);
    }

    private void CreateMarkingRadioButton(){
        JTextField jtfSelectButton = new JTextField(10);
        JButton jbtnSelect = new JButton("Select");
        JRadioButton jrbOne = new JRadioButton("One");
        JRadioButton jrbTwo = new JRadioButton("Two");
        JRadioButton jrbThree = new JRadioButton("Three");

        ButtonGroup bg = new ButtonGroup();
        bg.add(jrbOne);
        bg.add(jrbTwo);
        bg.add(jrbThree);

        jbtnSelect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(jtfSelectButton.getText().equals(jrbOne.getText()))
                    jrbOne.setSelected(true);
                else if(jtfSelectButton.getText().equals(jrbTwo.getText()))
                    jrbTwo.setSelected(true);
                else if(jtfSelectButton.getText().equals(jrbThree.getText()))
                    jrbThree.setSelected(true);
                else JOptionPane.showMessageDialog(jbtnSelect, "There is no such button!");
            }
        });

        jpnlMarkRadioButton.add(jtfSelectButton);
        jpnlMarkRadioButton.add(jbtnSelect);
        jpnlMarkRadioButton.add(jrbOne);
        jpnlMarkRadioButton.add(jrbTwo);
        jpnlMarkRadioButton.add(jrbThree);

    }

    private void CreateMarkingChackBoxes(){
        JTextField jtfSelectCheckBox = new JTextField(10);
        JButton jbtnSelectCheckBox = new JButton("Select this");
        JCheckBox jcbOne = new JCheckBox("One");
        JCheckBox jcbTwo = new JCheckBox("Two");
        JCheckBox jcbThree = new JCheckBox("Three");

        jbtnSelectCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String str;
                str = jtfSelectCheckBox.getText();
                String [] checkboxKeys= new String [3];
                checkboxKeys = str.split(" ");
                for (int i=0; i<3; i++) {
                    if (checkboxKeys[i].equals(jcbOne.getText()))
                        jcbOne.setSelected(true);
                    else if (checkboxKeys[i].equals(jcbTwo.getText()))
                        jcbTwo.setSelected(true);
                    else if (checkboxKeys[i].equals(jcbThree.getText()))
                        jcbThree.setSelected(true);
                    else JOptionPane.showMessageDialog(jbtnSelectCheckBox, "There is no such CheckButton!");
                }
            }
        });

        jpnlMarkCheckBoxes.add(jtfSelectCheckBox);
        jpnlMarkCheckBoxes.add(jbtnSelectCheckBox);
        jpnlMarkCheckBoxes.add(jcbOne);
        jpnlMarkCheckBoxes.add(jcbTwo);
        jpnlMarkCheckBoxes.add(jcbThree);

    }

    private void CreateAdditionToTable(){
        JTable tbl = new JTable(5,2);
        JTextField jtfNewValue = new JTextField(12);
        JButton jbtnAddToFirst = new JButton("Add to first column.");
        JButton jbtnMoveToSecond = new JButton("Move to second column.");
        JButton jbtnMoveToFirst = new JButton("Move to first column.");

        jpnlAddToTable.add(jtfNewValue);
        jpnlAddToTable.add(jbtnAddToFirst);
        jpnlAddToTable.add(jbtnMoveToSecond);
        jpnlAddToTable.add(jbtnMoveToFirst);
        jpnlAddToTable.add(tbl);

        jbtnAddToFirst.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(check == 5)
                    JOptionPane.showMessageDialog(tbl, "There is no place in first column!");
                else {
                    tbl.setValueAt(jtfNewValue.getText(), check, 0);
                    check++;
                }
            }
        });

        jbtnMoveToSecond.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String str = "";
                tbl.setValueAt(tbl.getValueAt((check-1),0), (check-1), 1);
                tbl.setValueAt(str ,(check-1), 0);
            }
        });

        jbtnMoveToFirst.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String str = "";
                tbl.setValueAt(tbl.getValueAt((check-1),1), (check-1), 0);
                tbl.setValueAt(str ,(check-1), 1);
            }
        });

    }

    private void AddPanels(){
        jfrmStorageOfTasks.getContentPane().add(jpnlAddToComboBox);
        jfrmStorageOfTasks.getContentPane().add(jpnlSetAndChangeNames);
        jfrmStorageOfTasks.getContentPane().add(jpnlMarkRadioButton);
        jfrmStorageOfTasks.getContentPane().add(jpnlMarkCheckBoxes);
        jfrmStorageOfTasks.getContentPane().add(jpnlAddToTable);
    }
}
