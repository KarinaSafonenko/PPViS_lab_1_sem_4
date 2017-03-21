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
import javax.swing.Timer;

/**
 * Created by Admin on 10.03.2017.
 */

public class MainFrame {
    int check = 0;
    JPanel comboBoxPanel;
    JPanel dynamicButtonNamePanel;
    JPanel radioButtonsPanel;
    JPanel checkBoxesPanel;
    JPanel dynamicTablePanel;
    JFrame storage;
    JButton jbtnStartMoving;
    JButton jbtnStopMoving;
    JButton jbtnAddText;
    JButton jbtnSetName;
    JButton jbtnGetName;
    JButton jbtnSelect;
    JButton jbtnSelectCheckBox;
    JButton jbtnAddToFirst;
    JButton jbtnMoveToSecond;
    JButton jbtnMoveToFirst;
    Timer swTimer;

    public MainFrame() {
        storage = new JFrame("by/safonenko/bsuir/ppvis/Widget");
        storage.getContentPane().setLayout(new FlowLayout());
        storage.setSize(350, 800);
        storage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jbtnStartMoving = new JButton("start moving");
        jbtnStopMoving = new JButton("stop moving");
        storage.getContentPane().add(jbtnStartMoving);
        storage.getContentPane().add(jbtnStopMoving);


        createComboBoxPanel();
        createDynamicButtonNamePanel();
        createRadioButtonPanel();
        createCheckBoxesPanel();
        createDynamicTablePanel();
        addPanels();
        createInstrumentsForMovingText();

        storage.setVisible(true);
    }

    private void createInstrumentsForMovingText(){
        ActionListener timerAl = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                move(jbtnAddText);
                move(jbtnSetName);
                move(jbtnGetName);
                move(jbtnSelect);
                move(jbtnSelectCheckBox);
                move(jbtnAddToFirst);
                move(jbtnMoveToSecond);
                move(jbtnMoveToFirst);
            }
        };
        swTimer = new Timer(100, timerAl);

        jbtnStartMoving.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                swTimer.start();
            }
        });

        jbtnStopMoving.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                swTimer.stop();
            }
        });
    }

    private void move(JButton someButton){
            String buttonName;
            String reName;
            char firstValue;
            buttonName = someButton.getText();
            int length = buttonName.length();
            firstValue = buttonName.charAt(0);
            reName = buttonName.substring(1, length);
            someButton.setText(reName + firstValue);
    }

    private void createComboBoxPanel() {
        comboBoxPanel = new JPanel();
        comboBoxPanel.setPreferredSize(new Dimension(150, 230));
        comboBoxPanel.setOpaque(true);
        comboBoxPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        JLabel jlab1 = new JLabel("Add to ComboBox");
        JTextField jtfAddText = new JTextField(10);
        JComboBox jcbGetText = new JComboBox();
        jcbGetText.setEditable(true);
        jbtnAddText = new JButton("add text ");
        comboBoxPanel.add(jlab1);

        jbtnAddText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String item = jtfAddText.getText();
                if (item == null) return;
                int i;
                int k = 0;
                for (i = 0; i < jcbGetText.getItemCount(); i++) {
                    if (item.equals(jcbGetText.getItemAt(i)) || item.equals("")) {
                        JOptionPane.showMessageDialog(jcbGetText, "Text has already existed!");
                        k++;
                    }
                }
                if (k == 0 && i == jcbGetText.getItemCount()){
                    jcbGetText.addItem(item);
                }
            }
        });

        comboBoxPanel.add(jtfAddText);
        comboBoxPanel.add(jcbGetText);
        comboBoxPanel.add(jbtnAddText);
    }

    private void createDynamicButtonNamePanel() {
        dynamicButtonNamePanel = new JPanel();
        dynamicButtonNamePanel.setPreferredSize(new Dimension(150, 230));
        dynamicButtonNamePanel.setOpaque(true);
        dynamicButtonNamePanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        JLabel jlab2 = new JLabel("Set and change names");
        JTextField jtfAddInf = new JTextField(10);
        jbtnSetName = new JButton("give it a name ");
        jbtnGetName = new JButton("empty ");
        dynamicButtonNamePanel.add(jlab2);

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

        dynamicButtonNamePanel.add(jtfAddInf);
        dynamicButtonNamePanel.add(jbtnSetName);
        dynamicButtonNamePanel.add(jbtnGetName);
    }

    private void createRadioButtonPanel() {
        radioButtonsPanel = new JPanel();
        radioButtonsPanel.setPreferredSize(new Dimension(150, 230));
        radioButtonsPanel.setOpaque(true);
        radioButtonsPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        JLabel jlab3 = new JLabel("Mark RadioButton");
        JTextField jtfSelectButton = new JTextField(10);
        jbtnSelect = new JButton("select ");
        JRadioButton jrbOne = new JRadioButton("One");
        JRadioButton jrbTwo = new JRadioButton("Two");
        JRadioButton jrbThree = new JRadioButton("Three");

        radioButtonsPanel.add(jlab3);

        ButtonGroup bg = new ButtonGroup();
        bg.add(jrbOne);
        bg.add(jrbTwo);
        bg.add(jrbThree);

        jbtnSelect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (jtfSelectButton.getText().equals(jrbOne.getText()))
                    jrbOne.setSelected(true);
                else if (jtfSelectButton.getText().equals(jrbTwo.getText()))
                    jrbTwo.setSelected(true);
                else if (jtfSelectButton.getText().equals(jrbThree.getText()))
                    jrbThree.setSelected(true);
                else JOptionPane.showMessageDialog(jbtnSelect, "There is no such button!");
            }
        });

        radioButtonsPanel.add(jtfSelectButton);
        radioButtonsPanel.add(jbtnSelect);
        radioButtonsPanel.add(jrbOne);
        radioButtonsPanel.add(jrbTwo);
        radioButtonsPanel.add(jrbThree);
    }

    private void  createCheckBoxesPanel() {
        checkBoxesPanel = new JPanel();
        checkBoxesPanel.setPreferredSize(new Dimension(150, 230));
        checkBoxesPanel.setOpaque(true);
        checkBoxesPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        JLabel jlab4 = new JLabel("Mark CheckBoxes");
        JTextField jtfSelectCheckBox = new JTextField(10);
        jbtnSelectCheckBox = new JButton("select this ");
        JCheckBox jcbOne = new JCheckBox("One");
        JCheckBox jcbTwo = new JCheckBox("Two");
        JCheckBox jcbThree = new JCheckBox("Three");
        checkBoxesPanel.add(jlab4);

        jbtnSelectCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String str;
                str = jtfSelectCheckBox.getText();
                String[] checkboxKeys = new String[3];
                checkboxKeys = str.split(" ");
                for (int i = 0; i < 3; i++) {
                    if (checkboxKeys[i].equals(jcbOne.getText())) {
                        if(jcbOne.isSelected())
                            jcbOne.setSelected(false);
                        else
                            jcbOne.setSelected(true);
                    }
                    else if (checkboxKeys[i].equals(jcbTwo.getText())) {
                        if(jcbTwo.isSelected())
                            jcbTwo.setSelected(false);
                        else
                            jcbTwo.setSelected(true);
                    }
                    else if (checkboxKeys[i].equals(jcbThree.getText())) {
                        if (jcbThree.isSelected())
                        jcbThree.setSelected(false);
                        else
                            jcbThree.setSelected(true);
                    }
                    else JOptionPane.showMessageDialog(jbtnSelectCheckBox, "There is no such CheckButton!");
                }
            }
        });
        checkBoxesPanel.add(jtfSelectCheckBox);
        checkBoxesPanel.add(jbtnSelectCheckBox);
        checkBoxesPanel.add(jcbOne);
        checkBoxesPanel.add(jcbTwo);
        checkBoxesPanel.add(jcbThree);
    }

    private void createDynamicTablePanel() {
        dynamicTablePanel = new JPanel();
        dynamicTablePanel.setPreferredSize(new Dimension(360, 180));
        dynamicTablePanel.setOpaque(true);
        dynamicTablePanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        JLabel jlab5 = new JLabel("Add and change columns");
        jlab5.setHorizontalTextPosition(SwingConstants.CENTER);

        dynamicTablePanel.add(jlab5);

        JTextField jtfNewValue = new JTextField(12);
        jbtnAddToFirst = new JButton("add to first column ");
        jbtnMoveToSecond = new JButton("move to second column ");
        jbtnMoveToFirst = new JButton("move to first column ");
        JTable tbl = new JTable(5, 2);

        dynamicTablePanel.add(tbl);
        dynamicTablePanel.add(jtfNewValue);
        dynamicTablePanel.add(jbtnMoveToSecond);
        dynamicTablePanel.add(jbtnAddToFirst);
        dynamicTablePanel.add(jbtnMoveToFirst);


        jbtnAddToFirst.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (check == 5) {
                    JOptionPane.showMessageDialog(tbl, "There is no place in first column!");
                }
                else {
                    tbl.setValueAt(jtfNewValue.getText(), check, 0);
                    check++;
                }
            }
        });

        jbtnMoveToSecond.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(tbl.getValueAt(check-1,1) == null) {
                    tbl.setValueAt(tbl.getValueAt((check - 1), 0), (check - 1), 1);
                    tbl.setValueAt(null, (check - 1), 0);
                }
            }
        });

        jbtnMoveToFirst.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(tbl.getValueAt(check-1,0) == null){
                    tbl.setValueAt(tbl.getValueAt((check - 1), 1), (check - 1), 0);
                    tbl.setValueAt(null, (check - 1), 1);
                }
            }
        });
    }

    private void addPanels() {
        storage.getContentPane().add(comboBoxPanel);
        storage.getContentPane().add(dynamicButtonNamePanel);
        storage.getContentPane().add(radioButtonsPanel);
        storage.getContentPane().add(checkBoxesPanel);
        storage.getContentPane().add(dynamicTablePanel);
    }
}
