package componenti;

import stampante.Colore;

public class ImmagineRaster extends Immagine{
	private Colore[][] pixel;	
	
	public ImmagineRaster(Colore[][] pixel) {
		super();
		this.pixel = pixel;
	}

	@Override
	public double consumoRed() {
		double red = 0;
		for(int r = 0; r< pixel.length; r++) {
			for(int c = 0; c< pixel[0].length; c++) {
				if(pixel[r][c]!= null) {
					red += pixel[r][c].getR();				
				}	
			}
		}
		return red;
	}
	
	@Override
	public double consumoGreen() {
		double green = 0;
		for(int r = 0; r< pixel.length; r++) {
			for(int c = 0; c< pixel[0].length; c++) {
				if(pixel[r][c]!= null) {
					green += pixel[r][c].getG();				
				}	
			}
		}
		return green;
	}
	
	@Override
	public double consumoBlue() {
		double blue = 0;
		for(int r = 0; r< pixel.length; r++) {
			for(int c = 0; c< pixel[0].length; c++) {
				if(pixel[r][c]!= null) {
					blue += pixel[r][c].getB();				
				}	
			}
		}
		return blue;
	}
}
