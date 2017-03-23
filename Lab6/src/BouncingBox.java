import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JComponent;

public class BouncingBox extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<BouncingFigure> figures = new ArrayList<BouncingFigure>();

	public void add(BouncingFigure f) {
		figures.add(f);
	}



	public void paintComponent(Graphics g) {
		for (BouncingFigure f : figures) {
			f.draw(g); f.move();


			if(f.getTrajectory() !=0 && f.getTrajectory() !=180){
				if(f.getTrajectory()>180 && f.getTrajectory()<270){
					if(f.leftBorderCollision() && f.lowerBorderCollision(this.getHeight())){
						f.setTrajectory(f.getTrajectory()+(180));
					}
					else if(f.leftBorderCollision()){
						f.setTrajectory(f.getTrajectory()+(90));
					}
					else if(f.lowerBorderCollision(this.getHeight())){
						f.setTrajectory(f.getTrajectory()-(90));
					}



				}
				else if(f.getTrajectory()>90 &&f.getTrajectory()<180){
					if(f.leftBorderCollision() && f.upperBorderCollision()){
						f.setTrajectory(f.getTrajectory()+(180));
					}
					else if(f.leftBorderCollision()){
						f.setTrajectory(f.getTrajectory()-(90));
					}

					else if(f.upperBorderCollision()){
						f.setTrajectory(f.getTrajectory()+(90));
					}

				}

				else if(f.getTrajectory()>0 &&f.getTrajectory()<90){
					if(f.rightBorderCollision(this.getWidth()) && f.upperBorderCollision()){
						f.setTrajectory(f.getTrajectory()+(180));
					}

					else if(f.rightBorderCollision(this.getWidth())){
						f.setTrajectory(f.getTrajectory()+(90));
					}
					else if(f.upperBorderCollision()){
						f.setTrajectory(f.getTrajectory()+(270));
					}

				}
				else if(f.getTrajectory()>270 &&f.getTrajectory()<360){
					if(f.rightBorderCollision(this.getWidth()) && f.lowerBorderCollision(this.getHeight())){
						f.setTrajectory(f.getTrajectory()+(180));
					}

					else if(f.rightBorderCollision(this.getWidth())){
						f.setTrajectory(f.getTrajectory()-(90));
					}
					else if(f.lowerBorderCollision(this.getHeight())){
						f.setTrajectory(f.getTrajectory()-(270));
					}

				}
			}

			else{
				if(f.leftBorderCollision()){
					f.setTrajectory(f.getTrajectory()-(180));
				}
				else if(f.lowerBorderCollision(this.getHeight())){
					f.setTrajectory(f.getTrajectory()-(180));
				}
				else if(f.rightBorderCollision(this.getWidth())){
					if(f.getTrajectory()==0){
						f.setTrajectory(f.getTrajectory()+(180));
					}
					else{
						f.setTrajectory(f.getTrajectory()-(180));

					}
				}
				else if(f.upperBorderCollision()){
					f.setTrajectory(f.getTrajectory()+(180));
				}

			}//end of first if


		}//end of for loop

	}//end of paintComponent method
}
