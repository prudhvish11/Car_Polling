package ABC;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class first extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					first frame = new first();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public first() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 962, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnWelcomeToData = new JTextPane();
		txtpnWelcomeToData.setEditable(false);
		txtpnWelcomeToData.setBackground(Color.WHITE);
		txtpnWelcomeToData.setFont(new Font("Arial", Font.BOLD, 33));
		txtpnWelcomeToData.setForeground(Color.BLACK);
		txtpnWelcomeToData.setText("WELCOME TO TARGARYEN'S CAR-POOLING");
		txtpnWelcomeToData.setBounds(96, 28, 753, 51);
		contentPane.add(txtpnWelcomeToData);
		
		JTextPane txtpnyouCanFind = new JTextPane();
		txtpnyouCanFind.setEditable(false);
		txtpnyouCanFind.setForeground(Color.BLACK);
		txtpnyouCanFind.setFont(new Font("Arial", Font.BOLD, 13));
		txtpnyouCanFind.setText("1.YOU CAN FIND CAR-POOL\r\n2.VERIFIED PROFILES ONLY\r\n3.YOU CAN KNOW YOUR POOL HISTORY \r\n4.CALCULATED PRICE WILL BE GIVEN\r\n");
		txtpnyouCanFind.setBounds(25, 419, 282, 74);
		contentPane.add(txtpnyouCanFind);
		
		JButton btnNewButton = new JButton("PRESS THIS TO CONTINUE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_1 i=new GUI_1();
				i.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(652, 423, 270, 51);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\project\\1.jpeg"));
		lblNewLabel.setBounds(0, 0, 948, 503);
		contentPane.add(lblNewLabel);
	}

}