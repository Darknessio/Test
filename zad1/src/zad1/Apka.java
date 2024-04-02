package zad1;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

public class Apka {
	
	static JSlider slajder1, slajder2;
	static JLabel label_slajder1, label_slajder2;
	static JTable tab;
	static JList  lista;
	static Info okno;
	static JFrame frame;
	static JTextArea tb;
	
	static String filePath = "table_data.csv";
	
	static WindowListener exitListener = new WindowAdapter() {

	    @Override
	    public void windowClosing(WindowEvent e) {
	    	String[] opcje = { "Tak", "Nie" };
	        int potwierdz = JOptionPane.showOptionDialog(
	             null, "Czy jestes pewien ze chcesz zamknac program?", 
	             "Potwierdzenie wyjscia", 0, 
	             2, null, opcje, null);
	        if (potwierdz == 0) {
	           System.exit(0);
	        }
	    }
	};

    public static void main(String args[]) {
    	
    	JMenuBar menuBar;
        JMenu fileMenu;
        JMenu editMenu;
        JMenu widokMenu;
        JMenu obliczMenu;
        JMenu helpMenu;
        JMenuItem loadItem;
        JMenuItem saveItem;
        JMenuItem exitItem, infoItem;
      
    	
    	Icon zamknij = new ImageIcon("icons/close.png");
    	Icon average = new ImageIcon("icons/average.png");
    	Icon minic = new ImageIcon("icons/min.png");
    	Icon maxic = new ImageIcon("icons/max.png");
    	Icon sigma = new ImageIcon("icons/sigma.png");
    	Icon zapisywanie = new ImageIcon("icons/save.png");
    	Icon plus = new ImageIcon("icons/plus.png");
    	Icon minus = new ImageIcon("icons/minus.png");
    	Icon about = new ImageIcon("icons/about.png");
    	Icon help = new ImageIcon("icons/help.png");
  		Icon zero = new ImageIcon("icons/zero.png");
  		Icon print = new ImageIcon("icons/print.png");
  
  		
  		//F R A M E
 
        frame = new JFrame("Program");
        frame.setBounds(700, 350, 500, 500);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(exitListener);
	  
        // ===============================
        // L I S T A        L I S T A
        // ===============================
        String SLista[]= { "Suma", "Srednia", "MAX i MIN"};
        lista = new JList(SLista);
        lista.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        lista.setVisibleRowCount(1);
    	
       
        // ===============================
        // J M E N U		J M E N U
        // ===============================
        JMenuBar mb = new JMenuBar();
        
        // tworzenie menu wraz z jego opcjami
        
        fileMenu = new JMenu("Plik");
        editMenu = new JMenu("Edytuj");
        widokMenu = new JMenu("Widok");
        obliczMenu = new JMenu("Obliczenia");
        helpMenu = new JMenu("Pomoc");

        // tworzenie przedmiotów menu
        loadItem = new JMenuItem("Wczytaj");
        saveItem = new JMenuItem("Zapisz");
        exitItem = new JMenuItem("Wyjdz");
        infoItem = new JMenuItem("O autorze");

        //przypisanie do menu file powyższych przedmiotów
        fileMenu.add(loadItem);
        loadItem.addActionListener(e -> System.out.println("Wczytales plik")); // po kliknięciu wczytuje plik
        loadItem.setMnemonic(KeyEvent.VK_L); // lima aby załadować

        fileMenu.add(saveItem);
        saveItem.addActionListener(e -> System.out.println("Zapisales plik"));
        saveItem.setMnemonic(KeyEvent.VK_S); // sierra aby zapisać

        fileMenu.add(exitItem);
        //exitItem.setIcon(exitIcon.ImageIcon(exit.png));
        exitItem.addActionListener(e -> System.exit(0)); // akcja przycisku
        exitItem.setMnemonic(KeyEvent.VK_E); // echo aby wyjść

        helpMenu.add(infoItem);
        infoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                okno = new Info();
            }
        });

        mb.add(fileMenu);
        mb.add(editMenu);
        mb.add(widokMenu);
        mb.add(obliczMenu);
        mb.add(helpMenu);
		
        // ===============================
        // J T O O L   B A R
        // ===============================
        JToolBar narzedzia = new JToolBar();
		JButton toolDodaj = new JButton("",plus);  // przyciski toolbar
		JButton toolZeruj = new JButton("",zero);  // przyciski toolbar
		JButton toolZapis = new JButton("",zapisywanie);  // przyciski toolbar
		JButton toolSuma = new JButton("",sigma);  // przyciski toolbar
		JButton toolSrednia = new JButton("",average);  // przyciski toolbar
		JButton toolMinMax = new JButton("",minic);  // przyciski toolbar
		
		narzedzia.add(toolDodaj);
		narzedzia.add(toolZeruj);
		narzedzia.add(toolZapis);
		narzedzia.addSeparator();
		narzedzia.addSeparator();
		narzedzia.addSeparator();
		narzedzia.addSeparator();
		narzedzia.addSeparator();
		narzedzia.add(toolSuma);
		narzedzia.add(toolSrednia);
		narzedzia.add(toolMinMax);
		/*
		btn1 = new JButton();
		btn2 = new JButton("przycisk2");
		btn1.addActionListener(e -> System.out.println("test"));
		btn1.setText("przycisk1");
		btn1.setFocusable(false);
		btn1.setBounds(200, 100, 250, 50);
		*/

		
		//Container pane = this.getContentPane();
		//pane.add(narzedzia, BorderLayout.NORTH);
		

        JPanel panel   = new JPanel(); 
        JPanel panell  = new JPanel();
        JLabel label   = new JLabel("Wprowadz Liczbe");
        JTextField tf  = new JTextField(10); 
        JButton reset  = new JButton("Reset");
        JButton zapisz = new JButton("Zapisz");
        JButton wyslij = new JButton("Wpisz");
        
        tb = new JTextArea();
        
        //tb.setHorizontalAlignment(SwingConstants.CENTER);
		tb.setBounds(50, 50, 50, 50);
		tb.setColumns(10);
		tb.setFont(new Font("Dialog",Font.PLAIN,20));
		Insets padding = new Insets(10, 10, 10, 10);
	    tb.setMargin(padding);
		tb.setEditable(false);
        
    
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
        
        Object[][] data = {
    			{0,0,0,0,0},
    			{0,0,0,0,0},
    			{0,0,0,0,0},
    			{0,0,0,0,0},
    			{0,0,0,0,0},
    	};
        String[] nazwyKolumn = {"1", "2", "3", "4", "5"};
        tab = new JTable(data, nazwyKolumn);
        tab.setBounds(30, 40, 200, 300);
        tab.setRowHeight(40);
        tab.setDefaultEditor(Object.class, null);
        tab.setCellSelectionEnabled(true);
        
        JPanel panel2 = new JPanel(); // the panel is not visible in output
        JPanel panel3 = new JPanel(); // the panel is not visible in output
        JPanel panel33 = new JPanel(); // the panel is not visible in output
        JPanel panel4 = new JPanel(); // the panel is not visible in output
        JPanel panel5 = new JPanel(); // Menu i Toolbar
        JPanel paneltest = new JPanel(); // Menu i Toolbar
        
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
        panel5.add(mb);
        panel5.add(narzedzia);
       // panel5.setLayout(new BoxLayout(panel5, BoxLayout.PAGE_AXIS));
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
        frame.getContentPane().add(BorderLayout.NORTH, narzedzia);
        frame.setJMenuBar(mb);
       // frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.getContentPane().add(BorderLayout.CENTER, panel4);
        frame.setVisible(true);

        //tab
        
        class listenerDodaj implements ActionListener{
            public void actionPerformed(ActionEvent e) {
            	int x = slajder1.getValue() - 1;
            	int y = slajder2.getValue() - 1;
                
            	try {
	            		int z = Integer.parseInt(tf.getText());
	                	tab.getModel().setValueAt(z,y,x);	
            		}
            		catch (NumberFormatException e1) {
            		JOptionPane.showMessageDialog(frame, "Podana wartosc nie jest liczba!");
            	}
            }
         }
        class listenerZeruj implements ActionListener{
            public void actionPerformed(ActionEvent e) {
            	// Define the action to be performed when the button is clicked
            	for (int i = 0; i < tab.getRowCount(); i++) {
                    for (int j = 0; j < tab.getColumnCount(); j++) {
                    		tab.getModel().setValueAt("0",i,j);
                    }
            	}
            }
         }
        class listenerZapis implements ActionListener{
            public void actionPerformed(ActionEvent e) {
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

                      System.out.println("Zapisano tablice do pliku: " + filePath);
                  } catch (IOException s) {
                      System.err.println("Error przy zapisywaniu tablicy do pliku: " + s.getMessage());
                  }
            }
         }
        
        class listenerWybranaKomorka implements ListSelectionListener{
        	public void valueChanged(ListSelectionEvent e) {
        		int wiersz  = tab.getSelectedRow()	  + 1;
        		int kolumna = tab.getSelectedColumn() + 1;
        		if (!e.getValueIsAdjusting()) 
                {
        			slajder2.setValue(wiersz);
        			slajder1.setValue(kolumna);
                }
        	  }
        }
        
        class listenerSuma implements ActionListener{
            public void actionPerformed(ActionEvent e) {
            	tablicaSuma();
            }
        }
        
        class listenerSrednia implements ActionListener{
            public void actionPerformed(ActionEvent e) {
            	tablicaSrednia();
            }
        }

        class listenerMinMax implements ActionListener{
            public void actionPerformed(ActionEvent e) {
            	tablicaMinMax();
            }
        }
        
        class listenerWybranaOpcja implements ListSelectionListener{
        	   public void valueChanged(ListSelectionEvent arg0) {
        		 listaOblicz();
               }
        }
        
        class listenerZmianaTablicy implements TableModelListener{
        	public void tableChanged(TableModelEvent e) {
        		listaOblicz();
        	  }
        }
    	
        /*
        // Add a component listener to listen for window resize events
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Calculate new row height based on window size
            	
                int newHeight = frame.getHeight() / (tab.getRowCount() * 2);
                tab.setRowHeight(newHeight);
                // Calculate new column width based on window size
                int newWidth = frame.getWidth() / tab.getColumnCount();
                for (int i = 0; i < tab.getColumnCount(); i++) {
                    tab.getColumnModel().getColumn(i).setPreferredWidth(newWidth);
                }

                //slajder2.setPreferredSize(new Dimension(20, 300));
            }
        });

        // Set initial row height and column width based on window size
        int initialHeight = panel33.getHeight() / (tab.getRowCount() * 2);
        tab.setRowHeight(initialHeight);

        int initialWidth = panel33.getWidth() / tab.getColumnCount();
        for (int i = 0; i < tab.getColumnCount(); i++) {
            tab.getColumnModel().getColumn(i).setPreferredWidth(initialWidth);
        }
        */
        lista.addListSelectionListener(new listenerWybranaOpcja());
        tab.getModel().addTableModelListener(new listenerZmianaTablicy());
        tab.getColumnModel().getSelectionModel().addListSelectionListener(new listenerWybranaKomorka());
        tab.getSelectionModel().addListSelectionListener(new listenerWybranaKomorka());
        
        wyslij.addActionListener(new listenerDodaj()); 
        reset.addActionListener(new listenerZeruj()); 
        zapisz.addActionListener(new listenerZapis()); 
        
        toolDodaj.addActionListener(new listenerDodaj()); 
        toolZeruj.addActionListener(new listenerZeruj()); 
        toolZapis.addActionListener(new listenerZapis()); 
        toolSuma.addActionListener(new listenerSuma()); 
        toolSrednia.addActionListener(new listenerSrednia()); 
        toolMinMax.addActionListener(new listenerMinMax()); 
    }
    
    public static void tablicaSuma() {
    	int sum = 0;
    	for (int i = 0; i < tab.getRowCount(); i++) {
            for (int j = 0; j < tab.getColumnCount(); j++)
            {
            	sum += Integer.parseInt(String.valueOf(tab.getValueAt(i, j)));
            }
    	}
    	 tb.setText("Suma:" + sum);
    }
    public static void tablicaSrednia() {
    	int sum = 0;
    	double srednia;
    	for (int i = 0; i < tab.getRowCount(); i++) {
            for (int j = 0; j < tab.getColumnCount(); j++)
            {
            	sum += Integer.parseInt(String.valueOf(tab.getValueAt(i, j)));
            }
    	}
    	 srednia = sum / 25.0;
    	 tb.setText("Srednia:" + srednia);
    }
    public static void tablicaMinMax() {
    	int min = Integer.parseInt(String.valueOf(tab.getValueAt(0, 0)));
    	int max = min;
    	int x;
    	for (int i = 0; i < tab.getRowCount(); i++) {
            for (int j = 0; j < tab.getColumnCount(); j++)
            {
            	x = Integer.parseInt(String.valueOf(tab.getValueAt(i, j)));
            	if(min > x)
            	{min = x;}
            	if(max < x)
            	{max = x;}
            }
    	}
    	tb.setText("MIN: " + min + "\n" + "MAX: " + max);
    }
    
    public static void listaOblicz() {
    		if(lista.getSelectedValue() != null) {
		    	String wybranaOpcja = lista.getSelectedValue().toString();
		    	if		(wybranaOpcja == "Suma") {
		    		tablicaSuma();
		    	}
		    	else if (wybranaOpcja == "Srednia") {
		    		tablicaSrednia();
		    	}
		    	else if (wybranaOpcja == "MAX i MIN") {
		    		tablicaMinMax();
		    	}
		    	else{
		    		 System.err.println("Cos nie dziala :( [Wartosc Listy Nie pasuje]");
		    	}
    		}
    	}
}