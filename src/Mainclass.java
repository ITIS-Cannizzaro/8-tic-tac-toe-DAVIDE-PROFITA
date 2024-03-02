import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Mainclass implements ActionListener {
	
	static boolean daMettereX=true;
	static JButton[][] grigliaBottoni=new JButton[3][3];
	
	public static void main (String[] args) {
		Mainclass m = new Mainclass();
	}
	
	public Mainclass() {
		
		
		JFrame frame=new JFrame("Tris");
		JPanel panel= new JPanel();
			
		frame.add(panel);
		GridLayout layout= new GridLayout(4,3);
		
		for(int i=0;i<grigliaBottoni.length;i++) {
			for(int j=0;j<grigliaBottoni[i].length;j++) {
				grigliaBottoni[i][j]= new JButton();
				panel.add(grigliaBottoni[i][j]);
				grigliaBottoni[i][j].addActionListener(this);
			}
		}
		
		panel.setLayout(layout);
		frame.setSize(500,500);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		for(int i =0;i<grigliaBottoni.length;i++) {
			for(int j=0;j<grigliaBottoni[i].length;j++) {
				if(grigliaBottoni[i][j]==e.getSource()) {
					if(grigliaBottoni[i][j].getText().equals(null)) {
						if(daMettereX){
							grigliaBottoni[i][j].setText("X");
							daMettereX=false;
						}else{
							grigliaBottoni[i][j].setText("O");
							daMettereX=true;
						}
					}
					
				}
			}
		}
		
	}

}
