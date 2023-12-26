import java.awt.Color;


public class GammaCorrection {

	public static MyImage execute(MyImage input, double gammaR,  double gammaG, double gammaB) {

		MyImage output = new MyImage(input.width, input.height);

        // double gammaR = 2.0;
        // double gammaG = 0.5;
        // double gammaB = 0.5;


		for(int i = 0; i < input.height; i++) {
			for(int j = 0; j < input.width; j++) {
				
				Color color1 = input.getColor(j, i);

				int r = (int)(255 * Math.pow((double)color1.getRed()/255.0,1.0/gammaR));
                int g = (int)(255 * Math.pow((double)color1.getGreen()/255.0,1.0/gammaG));
                int b = (int)(255 * Math.pow((double)color1.getBlue()/255.0,1.0/gammaB));

				Color color2 = new Color(r, g, b);

				output.setColor(j, i, color2);
			}
		}
		
		return output;
	}

}

