package ABC;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ADD extends JFrame {

	private JPanel contentPane;
	private JTextField txtTravellingOutOf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ADD frame = new ADD();
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
	public ADD() {
		setTitle("ADD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTravellingOutOf = new JTextField();
		txtTravellingOutOf.setEditable(false);
		txtTravellingOutOf.setFont(new Font("Arial", Font.PLAIN, 34));
		txtTravellingOutOf.setText("Travelling out of town?");
		txtTravellingOutOf.setBounds(29, 111, 358, 40);
		contentPane.add(txtTravellingOutOf);
		txtTravellingOutOf.setColumns(10);
		
		JButton btnNewButton = new JButton("THEN USE TARGARYEN'S CAR-POOLING\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first f=new first();
				f.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 18));
		btnNewButton.setBounds(219, 429, 417, 51);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\project\\3.jpeg"));
		lblNewLabel.setBounds(10, 10, 642, 462);
		contentPane.add(lblNewLabel);
	}

}