import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Mainclass implements ActionListener {
	
	static boolean trisFatto=false;
	static short mossa=0;
	static JButton[][] grigliaBottoni=new JButton[3][3];
	static Font bottoni=new Font("helvetica",1,100);
	
	
	public static void main (String[] args) {
		Mainclass m = new Mainclass();
	}
	
	public Mainclass() {
		
		
		JFrame frame=new JFrame("Tris");
		JPanel panel= new JPanel();
			
		frame.add(panel);
		GridLayout layout= new GridLayout(3,3);
		
		
		for(int i=0;i<grigliaBottoni.length;i++) {
			for(int j=0;j<grigliaBottoni[i].length;j++) {
				grigliaBottoni[i][j]= new JButton();
				grigliaBottoni[i][j].setFont(bottoni);
				panel.add(grigliaBottoni[i][j]);
				grigliaBottoni[i][j].setBackground(Color.white);
				grigliaBottoni[i][j].addActionListener(this);
			}
		}
		
		panel.setLayout(layout);
		frame.setSize(500,500);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(!trisFatto) {
			for(int i =0;i<grigliaBottoni.length;i++) {
				for(int j=0;j<grigliaBottoni[i].length;j++) {
					if(grigliaBottoni[i][j]==e.getSource()) {
						if(grigliaBottoni[i][j].getText().equals("")) {
							if(mossa%2==0)
								grigliaBottoni[i][j].setText("X");
							else
								grigliaBottoni[i][j].setText("O");
							mossa++;
						}	
					}
				}
			}
			if(mossa>=5) 
				controllaTris();
		}else 
			for(int i=0;i<grigliaBottoni.length;i++) 
				for(int j=0;j<grigliaBottoni[i].length;j++) {
					grigliaBottoni[i][j].setText("");
					grigliaBottoni[i][j].setBackground(Color.white);
					mossa=0;
					trisFatto=false;
				}
			
		
		
	}
	
	void controllaTris() {
		for(int i=0;i<grigliaBottoni.length;i++) {
				if( (grigliaBottoni[i][0].getText().equals("X") && 
					grigliaBottoni[i][1].getText().equals("X") && 
					grigliaBottoni[i][2].getText().equals("X")) ||
					(grigliaBottoni[i][0].getText().equals("O") && 
					grigliaBottoni[i][1].getText().equals("O") && 
					grigliaBottoni[i][2].getText().equals("O"))
				) {	
					grigliaBottoni[i][0].setBackground(Color.green);
					grigliaBottoni[i][1].setBackground(Color.green);
					grigliaBottoni[i][2].setBackground(Color.green);
					trisFatto=true;
				}
		}
		for(int i=0;i<grigliaBottoni.length;i++) {
			if( (grigliaBottoni[0][i].getText().equals("X") && 
				grigliaBottoni[1][i].getText().equals("X") && 
				grigliaBottoni[2][i].getText().equals("X")) ||
				(grigliaBottoni[0][i].getText().equals("O") && 
				grigliaBottoni[1][i].getText().equals("O") && 
				grigliaBottoni[2][i].getText().equals("O"))
			) {	
				grigliaBottoni[0][i].setBackground(Color.green);
				grigliaBottoni[1][i].setBackground(Color.green);
				grigliaBottoni[2][i].setBackground(Color.green);
				trisFatto=true;
			}
	}
		
		if( (grigliaBottoni[0][0].getText().equals("X") && 
			grigliaBottoni[1][1].getText().equals("X") && 
			grigliaBottoni[2][2].getText().equals("X")) ||
			(grigliaBottoni[0][0].getText().equals("O") && 
			grigliaBottoni[1][1].getText().equals("O") && 
			grigliaBottoni[2][2].getText().equals("O"))
		) {
			for(int i=0;i<grigliaBottoni.length;i++) {
				grigliaBottoni[i][i].setBackground(Color.green);
			}
			trisFatto=true;
		}
		
		if( (grigliaBottoni[0][2].getText().equals("X") && 
			grigliaBottoni[1][1].getText().equals("X") && 
			grigliaBottoni[2][0].getText().equals("X")) ||
			(grigliaBottoni[0][2].getText().equals("O") && 
			grigliaBottoni[1][1].getText().equals("O") && 
			grigliaBottoni[2][0].getText().equals("O"))
		) {
			for(int i=0;i<grigliaBottoni.length;i++) {
				grigliaBottoni[i][grigliaBottoni.length-1-i].setBackground(Color.green);
			}
			trisFatto=true;
		}
		
		
		
		
	}
	
	
}
