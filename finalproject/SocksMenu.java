import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public class SocksMenu {
	static private JFrame frame;
	static private JButton backButton, orderButton;
	static private JTextField textField;
	static private GridBagConstraints gbc;
	private JTable table;
	DefaultTableModel dtm;
	Double[] priceSocks;
	Double[] priceGift;
	Double[] priceFabric;
	double totalPrice = 0;
	double p1, p2, p3, p4, p5, p6, p7, p8, p9;
	double g1, g2, g3, g4;
	double f1, f2;

	private JSpinner[] numSpinnerSocks;
	static private JLabel[] socksLabel;
	static private JLabel[] socksImage;
	private String[] fileSocks;

	private JSpinner[] numSpinnerGift;
	static private JLabel[] giftLabel;
	static private JLabel[] giftImage;
	private String[] fileGift;

	private JSpinner[] numSpinnerFabric;
	static private JLabel[] fabricLabel;
	static private JLabel[] fabricImage;
	private String[] fileFabric;

	private static final int SOCKS_ELEMENTS = 9;
	private static final int GIFT_ELEMENTS = 4;
	private static final int FABRIC_ELEMENTS = 2;

	double total = 0;
	double socks1, socks2, socks3, socks4, socks5, socks6, socks7, socks8, socks9;
	double gift1, gift2, gift3, nogift;
	double fabric1, fabric2;

	double totalForSocks;
	double totalForGift;
	double totalForFabric;

	void createAndShowGUI() throws IOException {
		frame = new JFrame("Socks Menu ");
		frame.setBounds(100, 100, 750, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		JLabel lblSocksOrdered = new JLabel("Socks Ordered");
		lblSocksOrdered.setBounds(529, 11, 90, 20);

		frame.getContentPane().add(lblSocksOrdered);

		table = new JTable();
		backButton = new JButton();
		orderButton = new JButton();
		dtm = new DefaultTableModel(0, 0);
		final String header[] = new String[] { "Item", "Qty", "Price", "Spinner" };
		dtm.setColumnIdentifiers(header);
		dtm.addRow(header);
		table = new JTable();
		table.setModel(dtm);
		table.setBackground(Color.WHITE);
		table.setBounds(475, 31, 1, 1); // int x, int y, int width, int height
		table.setSize(245, 300); // width,height
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setMinWidth(0); // hide spinner
											// column
		table.getColumnModel().getColumn(3).setMaxWidth(0); // hide spinner
											// column
		table.setShowGrid(false); // remove cell boarder
		frame.getContentPane().add(table);
		JLabel lblTotal = new JLabel("Total  : ");
		lblTotal.setBounds(519, 340, 46, 14);
		frame.getContentPane().add(lblTotal);
		
		textField = new JTextField();
		textField.setBounds(585, 340, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		orderButton = new JButton("Order");
		orderButton.setBounds(500, 385, 89, 23);
		frame.getContentPane().add(orderButton);
		
		backButton = new JButton("Back");
		backButton.setBounds(610, 385, 89, 23);
		frame.getContentPane().add(backButton);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		addIt(tabbedPane, "SOCKS");
		addIt1(tabbedPane, "GIFT");
		addIt2(tabbedPane, "FABRIC");
		tabbedPane.setBounds(18, 11, 450, 450);
		frame.getContentPane().add(tabbedPane);
		frame.setVisible(true);

		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MainMenu menu = new MainMenu();
					menu.main(header);
					// menu.createAndShowGUI();
					menu.setVisible(true);
					// setVisible(false);
					frame.dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		orderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "You not ordered anything yet");
				} else {
					try {
						OrderMenu order = new OrderMenu();
						order.main(header);
						order.setVisible(true);
						setVisible(false);
						frame.dispose();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

		});
	}

	void addIt(JTabbedPane tabbedPane, String text) throws IOException {
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.PINK);
		gbc = new GridBagConstraints(); // getting constraints for the specified
										// component
		gbc.insets = new Insets(10, 0, 0, 0);
		socksImage = new JLabel[SOCKS_ELEMENTS];
		socksLabel = new JLabel[SOCKS_ELEMENTS];
		numSpinnerSocks = new JSpinner[SOCKS_ELEMENTS];
		fileSocks = new String[SOCKS_ELEMENTS];
		priceSocks = new Double[SOCKS_ELEMENTS];

		fileSocks[0] = new String("socks.jpg");
		fileSocks[1] = new String("sockss.jpg");
		fileSocks[2] = new String("cute.jpg");
		fileSocks[3] = new String("ttt.jpg");
		fileSocks[4] = new String("animal.jpg");
		fileSocks[5] = new String("polkadot.jpg");
		fileSocks[6] = new String("flower.jpg");
		fileSocks[7] = new String("pastel.jpg");
		fileSocks[8] = new String("korea.jpg");
		socksLabel[0] = new JLabel("Fruit Design");
		socksLabel[1] = new JLabel("Love Design");
		socksLabel[2] = new JLabel("Animal Design");
		socksLabel[3] = new JLabel("Fluffy Design");
		socksLabel[4] = new JLabel("Short Animal Design");
		socksLabel[5] = new JLabel("Polkadot Design");
		socksLabel[6] = new JLabel("Flower Design");
		socksLabel[7] = new JLabel("Pastel Design");
		socksLabel[8] = new JLabel("Korea Design");
		priceSocks[0] = 3.23;
		priceSocks[1] = 3.50;
		priceSocks[2] = 1.99;
		priceSocks[3] = 3.99;
		priceSocks[4] = 1.50;
		priceSocks[5] = 2.00;
		priceSocks[6] = 2.50;
		priceSocks[7] = 2.50;
		priceSocks[8] = 2.00;
		for (int i = 0; i < SOCKS_ELEMENTS; i++) {
			
			System.out.print(fileSocks[i]);	
			try {
			
			Image image = ImageIO.read(this.getClass().getResource(fileSocks[i]));
			Image imageScaled = image.getScaledInstance(80, 95, Image.SCALE_SMOOTH);
			//Image image = ImageIO.read(file[i]);
                        //Image imageScaled = image.getScaledInstance(80, 95, Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(imageScaled);
			SpinnerNumberModel spnummodel = new SpinnerNumberModel(0, 0, 10, 1); // value,minimum,maximum,stepSize
			numSpinnerSocks[i] = new JSpinner(spnummodel);
			numSpinnerSocks[i].addChangeListener(listenerForSocks);
			socksImage[i] = new JLabel(imageIcon);
			}catch(Exception e) {
				System.out.print(e);
			}
		}
		gbc.gridx = 0; // gridx 0 represent the most left
		for (int i = 0; i < SOCKS_ELEMENTS; i++) {
			if (i % 3 == 0) {
				gbc.gridy += 2;
				gbc.gridx = 0;
			}
			panel.add(socksImage[i], gbc);
			gbc.gridy++; // gridy---> add one row,for foodLabel
			panel.add(socksLabel[i], gbc);
			gbc.gridy--; // remove the row
			gbc.gridx++; // move to next column
			panel.add(numSpinnerSocks[i], gbc);
			gbc.gridx++; // move to next column
			tabbedPane.addTab(text, panel);
		}
	}
	
	void addIt1(JTabbedPane tabbedPane, String text) throws IOException {
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.PINK);
		GridBagConstraints gbc = new GridBagConstraints();
		giftImage = new JLabel[GIFT_ELEMENTS];
		giftLabel = new JLabel[GIFT_ELEMENTS];
		numSpinnerGift = new JSpinner[GIFT_ELEMENTS];
		priceGift = new Double[GIFT_ELEMENTS];

		fileGift = new String[GIFT_ELEMENTS];
		fileGift[0] = new String("ribbon.jpg");
		fileGift[1] = new String("card.jpg");
		fileGift[2] = new String("ribbonn.jpg");
		fileGift[3] = new String("none.jpg");

                giftLabel[0] = new JLabel("Ribbon & Card");
		giftLabel[1] = new JLabel("Card ONLY");
		giftLabel[2] = new JLabel("Ribbon ONLY");
		giftLabel[3] = new JLabel("None");

		priceGift[0] = 2.50;
		priceGift[1] = 2.00;
		priceGift[2] = 1.00;
		priceGift[3] = 0.00;

		for (int i = 0; i < GIFT_ELEMENTS; i++) {
			Image image = ImageIO.read(this.getClass().getResource(fileGift[i]));
			Image imageScaled = image.getScaledInstance(80, 95, Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(imageScaled);
			SpinnerNumberModel spnummodel = new SpinnerNumberModel(0, 0, 10, 1); // value,minimum,maximum,stepSize
			numSpinnerGift[i] = new JSpinner(spnummodel);
			numSpinnerGift[i].addChangeListener(listenerForGift);
			giftImage[i] = new JLabel(imageIcon);
		}
		gbc.gridx = 0; // gridx 0 represent the most left
		gbc.insets = new Insets(10, 5, 0, 0); // top,left,bottom,right
		for (int i = 0; i < GIFT_ELEMENTS; i++) {
			if (i % 3 == 0) {
				gbc.gridx = 0;
				gbc.gridy += 2;
			}
			panel.add(giftImage[i], gbc);
			gbc.gridy++; // gridy---> add one row,for foodLabel
			panel.add(giftLabel[i], gbc);
			gbc.gridy--; // remove the row
			gbc.gridx++; // move to next column
			panel.add(numSpinnerGift[i], gbc);
			gbc.gridx++; // move to next column
			tabbedPane.addTab(text, panel);

		}
	}

	void addIt2(JTabbedPane tabbedPane, String text) throws IOException {
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.PINK);
		GridBagConstraints gbc = new GridBagConstraints();
		fabricImage = new JLabel[FABRIC_ELEMENTS];
		fabricLabel = new JLabel[FABRIC_ELEMENTS];
		numSpinnerFabric = new JSpinner[FABRIC_ELEMENTS];
		priceFabric = new Double[FABRIC_ELEMENTS];

		fileFabric = new String[FABRIC_ELEMENTS];
		fileFabric[0] = new String("ttt.jpg");
		fileFabric[1] = new String("ttt.jpg");

		fabricLabel[0] = new JLabel("Premium");
		fabricLabel[1] = new JLabel("Standard");

		priceFabric[0] = 1.00;
		priceFabric[1] = 0.00;

		for (int i = 0; i < FABRIC_ELEMENTS; i++) {
			Image image = ImageIO.read(this.getClass().getResource(fileFabric[i]));
			Image imageScaled = image.getScaledInstance(80, 95, Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(imageScaled);
			SpinnerNumberModel spnummodel = new SpinnerNumberModel(0, 0, 10, 1); // value,minimum,maximum,stepSize
			numSpinnerFabric[i] = new JSpinner(spnummodel);
			numSpinnerFabric[i].addChangeListener(listenerForFabric);
			fabricImage[i] = new JLabel(imageIcon);
		}
		gbc.gridx = 0; // gridx 0 represent the most left
		gbc.insets = new Insets(10, 5, 0, 0); // top,left,bottom,right
		for (int i = 0; i < FABRIC_ELEMENTS; i++) {
			if (i % 3 == 0) {
				gbc.gridx = 0;
				gbc.gridy += 2;
			}
			panel.add(fabricImage[i], gbc);
			gbc.gridy++; // gridy---> add one row,for foodLabel
			panel.add(fabricLabel[i], gbc);
			gbc.gridy--; // remove the row
			gbc.gridx++; // move to next column
			panel.add(numSpinnerFabric[i], gbc);
			gbc.gridx++; // move to next column
			tabbedPane.addTab(text, panel);
		}

	}

	ChangeListener listenerForSocks = new ChangeListener() {
		public void stateChanged(ChangeEvent e) {

			final int quantity = (int) ((JSpinner) e.getSource()).getValue();
			final int rows = table.getRowCount();
			for (int row = 0; row < rows; row++) {
				if (dtm.getValueAt(row, 3) == e.getSource()) {
					if (dtm.getValueAt(row, 0).equals("Fruit Design")) {
						dtm.setValueAt(quantity, row, 1); // obj, row, column
						dtm.setValueAt(p1 * quantity, row, 2);
						socks1 = p1 * quantity;

					} else if (dtm.getValueAt(row, 0).equals("Love Design")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(p2 * quantity, row, 2);
						socks2 = p2 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Animal Design")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(p3 * quantity, row, 2);
						socks3 = p3 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Fluffy Design")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(p4 * quantity, row, 2);
						socks4 = p4 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Short Animal Design")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(p5 * quantity, row, 2);
						socks5 = p5 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Polkadot Design")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(p6 * quantity, row, 2);
						socks6 = p6 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Flower Design")) {

						dtm.setValueAt(quantity, row, 1); // obj, row,
															// column
						dtm.setValueAt(p7 * quantity, row, 2);
						socks7 = p7 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Pastel Design")) {

						dtm.setValueAt(quantity, row, 1); // obj, row,
															// column
						dtm.setValueAt(p8 * quantity, row, 2);
						socks8 = p8 * quantity;
					} else if (dtm.getValueAt(row, 0).equals("Korea Design")) {

						dtm.setValueAt(quantity, row, 1); // obj, row,
															// column
						dtm.setValueAt(p9 * quantity, row, 2);
						socks9 = p9 * quantity;
					}

					if (quantity == 0) {
						dtm.removeRow(row);
					}
					totalForSocks = socks1 + socks2 + socks3 + socks4 + socks5 + socks6 + socks7 + socks8 + socks9;
					total = totalForSocks + totalForGift + totalForFabric;
					textField.setText(total + "");
					return;
					
				}
			}

			// there was no row with this JSpinner, so we have to add it
			for (int i = 0; i < SOCKS_ELEMENTS; i++) {
				// looking for the "clicked" JSpinner
				if (numSpinnerSocks[i] == e.getSource()) {
					totalPrice = priceSocks[i];
					switch (socksLabel[i].getText()) {
					case "Fruit Design":
						p1 = 3.23;
						socks1 = p1;
						break;
					case "Love Design":
						p2 = 3.50;
						socks2 = p2;
						break;
					case "Animal Design":
						p3 = 1.99;
						socks3 = p3;
						break;
					case "Fluffy Design":
						p4 = 3.99;
						socks4 = p4;
						break;
					case "Short Animal Design":
						p5 = 1.50;
						socks5 = p5;
						break;
					case "Polkadot Design":
						p6 = 2.00;
						socks6 = p6;
						break;
					case "Flower Design":
						p7 = 2.50;
						socks7 = p7;
						break;
					case "Pastel Design":
						p8 = 2.50;
						socks8 = p8;
						break;
					case "Korea Design":
						p9 = 2.00;
						socks9 = p9;
						break;
					}
					totalForSocks = socks1 + socks2 + socks3 + socks4 + socks5 + socks6 + socks7 + socks8 + socks9;
					total = totalForSocks + totalForGift + totalForFabric;
					textField.setText(total + "");
					dtm.addRow(new Object[] { socksLabel[i].getText(), quantity, totalPrice, numSpinnerSocks[i] });
					return;
				}

			}
		}
	};
	
	ChangeListener listenerForGift = new ChangeListener() {
		public void stateChanged(ChangeEvent e) {

			final int quantity = (int) ((JSpinner) e.getSource()).getValue();
			final int rows = table.getRowCount();
			for (int row = 0; row < rows; row++) {
				if (dtm.getValueAt(row, 3) == e.getSource()) {
					if (dtm.getValueAt(row, 0).equals("Raspberry")) {
						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(g1 * quantity, row, 2);
						gift1 = g1 * quantity;

					} else if (dtm.getValueAt(row, 0).equals("Chocolate Pudding")) {
						dtm.setValueAt(quantity, row, 1); // obj, row,
															// column
						dtm.setValueAt(g2 * quantity, row, 2);
						gift2 = g2 * quantity;

					} else if (dtm.getValueAt(row, 0).equals("Blue Hawailan")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(g3 * quantity, row, 2);
						gift3 = g3 * quantity;

					} else if (dtm.getValueAt(row, 0).equals("Pina")) {

						dtm.setValueAt(quantity, row, 1);
						dtm.setValueAt(g4 * quantity, row, 2);
						nogift = g4 * quantity;

				         }
					if (quantity == 0) {
						dtm.removeRow(row);
					}
					totalForGift = gift1 + gift2 + gift3 + nogift;
					total = totalForSocks + totalForGift + totalForFabric;
					textField.setText(total + "");

					return;
				}
			}

			// there was no row with this JSpinner, so we have to add it
			for (int i = 0; i < GIFT_ELEMENTS; i++) {
				// looking for the "clicked" JSpinner
				if (numSpinnerGift[i] == e.getSource()) {
					totalPrice = priceGift[i];
					switch (giftLabel[i].getText()) {
					case "Card & Ribbon":
						g1 = 2.50;
						gift1 = g1;
						break;
					case "Card ONLY":
						g2 = 2.00;
						gift2 = g2;
						break;
					case "Ribbon ONLY":
						g3 = 1.00;
						gift3 = g3;
						break;
					case "None":
						g4 = 0.00;
						nogift = g4;
						break;
					
					}
					totalForGift= gift1 + gift2 + gift3 + nogift ;
					total = totalForSocks + totalForGift + totalForFabric;
					textField.setText(total + "");
					dtm.addRow(new Object[] { giftLabel[i].getText(), quantity, totalPrice, numSpinnerGift[i] });
					return;
				}

			}

		}
		
		
	};

	ChangeListener listenerForFabric = new ChangeListener() {
		public void stateChanged(ChangeEvent e) {

			final int quantity = (int) ((JSpinner) e.getSource()).getValue();
			final int rows = table.getRowCount();

			for (int row = 0; row < rows; row++) {
				if (dtm.getValueAt(row, 3) == e.getSource()) {
					if (dtm.getValueAt(row, 0).equals("Strawberry Cake")) {
						dtm.setValueAt(quantity, row, 1); // obj, row,
						fabric1 = f1 * quantity; // column
						dtm.setValueAt(f1 * quantity, row, 2);
					} else if (dtm.getValueAt(row, 0).equals("Chocolate Cake")) {
						dtm.setValueAt(quantity, row, 1); // obj, row, // column
						dtm.setValueAt(f2 * quantity, row, 2);
						fabric2 = f2 * quantity;
					}
					if (quantity == 0) {
						dtm.removeRow(row);
					}
					totalForFabric= fabric1 + fabric2;
					total = totalForSocks + totalForGift+ totalForFabric;
					textField.setText(total + "");
					return;
				}
			}

			// there was no row with this JSpinner, so we have to add it
			for (int i = 0; i < FABRIC_ELEMENTS; i++) {
				// looking for the "clicked" JSpinner
				if (numSpinnerFabric[i] == e.getSource()) {
					totalPrice = priceFabric[i];
					switch (fabricLabel[i].getText()) {
					case "Premium":
						f1 = 1.00;
						fabric1 = f1;
						break;
					case "Standard":
						f2 = 0.00;
						fabric2 = f2;
						break;
					}
					totalForFabric= fabric1 + fabric2;
					total = totalForSocks + totalForGift+ totalForFabric;
					textField.setText(total + "");
					dtm.addRow(new Object[] { fabricLabel[i].getText(), quantity, totalPrice, numSpinnerFabric[i] });
					return;
				}

			}
		}

	};


	
	

	public void setVisible(boolean b) throws IOException {
	    
	    JOptionPane.showMessageDialog(frame, "ORDER RECEIPT"+"\n--------------------------"+"\nTotal For Socks: " + totalForSocks +  "\nTotal For Gift: " + totalForGift + 

"\nTotal For Fabric: " + totalForFabric +"\n--------------------------"+"\n Amount To Pay: " + total, 

"INVOICE .", JOptionPane.INFORMATION_MESSAGE);
	    
	}
}
