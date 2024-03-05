package zad1;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.GridLayout;
import java.io.*;
import javax.swing.border.EmptyBorder;



class Apka {
	
	static JSlider slajder1;
	static JSlider slajder2;
	static JLabel label_slajder1;
	static JLabel label_slajder2;
	static JTable tab;
	static JList  lista;
	
    public static void main(String args[]) {
    	
        // ===============================
        // L I S T A        L I S T A
        // ===============================
        String week[]= { "Suma", "Srednia", "MAX i MIN"};
        lista = new JList(week);
        lista.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        lista.setVisibleRowCount(1);
    	
        //Creating the Frame
        JFrame frame = new JFrame("Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(700, 350, 500, 500);
        
        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("PLIK");
        JMenu m2 = new JMenu("Pomoc");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m22 = new JMenuItem("Save as");
        m1.add(m11);
        m1.add(m22);

        //Creating the panel at bottom and adding components
        JPanel panel   = new JPanel(); // the panel is not visible in output
        JPanel panell  = new JPanel();
        JLabel label   = new JLabel("Enter Text");
        JTextField tf  = new JTextField(10); // accepts upto 10 characters
        JButton reset  = new JButton("Reset");
        JButton zapisz = new JButton("Zapisz");
        JButton wyslij = new JButton("Wyslij");
        
        // Text Area at the Center
        JTextArea ta = new JTextArea();
        JTextArea tb = new JTextArea();
        
    
        // ===============================
        // S L A J D E R Y  S L A J D E R Y
        // ===============================
        
        slajder1 = new JSlider(1, 5, 1);
        slajder1.setPaintTrack(true);
        slajder1.setPaintTicks(true);
        slajder1.setPaintLabels(true);
        slajder1.setMajorTickSpacing(1);
        slajder1.setBorder(new EmptyBorder(0, 30, 0, 30));
        label_slajder1 = new JLabel();

        slajder1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) { // To prevent reacting to intermediate value changes
                    int value = source.getValue();
                    label_slajder1.setText("Value: " + value);
                }
            }
        });
        
        slajder2 = new JSlider(1, 5, 1);
        slajder2.setPaintTrack(true);
        slajder2.setPaintTicks(true);
        slajder2.setPaintLabels(true);
        slajder2.setMajorTickSpacing(1);
        slajder2.setBorder(new EmptyBorder(2, 0, 12, 0));
        slajder2.setInverted(true);
        label_slajder2 = new JLabel();

        slajder2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) { // To prevent reacting to intermediate value changes
                    int value = source.getValue();
                    label_slajder2.setText("Value: " + value);
                }
            }
        });
        slajder2.setOrientation(SwingConstants.VERTICAL);
        
        //=========================================
        // T A B L I C A            T A B L I C A
        //=========================================
        JPanel b1 = new JPanel();
        b1.setPreferredSize(new Dimension(50, 50));
        
        tab = new JTable(5, 5);
        tab.setBounds(30, 40, 200, 300);
        tab.setRowHeight(40);
        
        JPanel panel2 = new JPanel(); // the panel is not visible in output
        JPanel panel3 = new JPanel(); // the panel is not visible in output
        JPanel panel33 = new JPanel(); // the panel is not visible in output
        JPanel panel4 = new JPanel(); // the panel is not visible in output
        panel2.add(slajder1);
        panel2.add(tab);
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
        panel3.add(b1);
        panel3.add(slajder2);
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.PAGE_AXIS));
        panel33.add(panel3);
        panel33.add(panel2);
        panel33.setLayout(new BoxLayout(panel33, BoxLayout.LINE_AXIS));
        panel4.add(panel33);
        panel4.add(tb);
        panel4.setLayout(new BoxLayout(panel4, BoxLayout.PAGE_AXIS));
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(wyslij);
        panel.add(reset);
        panel.add(zapisz);
        panell.add(panel);
        panell.add(lista);
        panell.setLayout(new BoxLayout(panell, BoxLayout.PAGE_AXIS));
        
        /*
        frame.setLayout(new GridLayout(0, 2));
        frame.getContentPane().add(panel);
        frame.getContentPane().add(mb);
        frame.getContentPane().add(ta);
        frame.getContentPane().add(tb);
        frame.setVisible(true);
         */
        
        //Adding Components to the frame.

        frame.getContentPane().add(BorderLayout.SOUTH, panell);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
       // frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.getContentPane().add(BorderLayout.CENTER, panel4);
        frame.setVisible(true);

        String filePath = "table_data.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write table data to the file
            for (int i = 0; i < tab.getRowCount(); i++) {
                for (int j = 0; j < tab.getColumnCount(); j++) {
                    writer.write(String.valueOf(tab.getValueAt(i, j)));
                    if (j < tab.getColumnCount() - 1) {
                        writer.write(",");
                    }
                }
                writer.newLine(); // Move to the next line for the next row
            }

            System.out.println("JTable data has been written to the file: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing JTable data to the file: " + e.getMessage());
        }

       
        wyslij.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Define the action to be performed when the button is clicked
            	int x = slajder1.getValue() - 1;
            	int y = slajder2.getValue() - 1;
                String z = tf.getText();
            	tab.getModel().setValueAt(z,y,x);
            }
        }); 
        
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Define the action to be performed when the button is clicked
            	for (int i = 0; i < tab.getRowCount(); i++) {
                    for (int j = 0; j < tab.getColumnCount(); j++) {
                    		tab.getModel().setValueAt("",i,j);
                    }
            	}
            	
            }
        });
        
        zapisz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Define the action to be performed when the button is clicked
            	  try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                      // Write table data to the file
                      for (int i = 0; i < tab.getRowCount(); i++) {
                          for (int j = 0; j < tab.getColumnCount(); j++) {
                              writer.write(String.valueOf(tab.getValueAt(i, j)));
                              if (j < tab.getColumnCount() - 1) {
                                  writer.write(",");
                              }
                          }
                          writer.newLine(); // Move to the next line for the next row
                      }

                      System.out.println("JTable data has been written to the file: " + filePath);
                  } catch (IOException s) {
                      System.err.println("Error writing JTable data to the file: " + s.getMessage());
                  }
            }
        }); 
        
    }
    
}