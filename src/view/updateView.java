package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class updateView extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateView frame = new updateView();
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
	public updateView() {
		setBounds(100, 100, 450, 300);

	}

}
