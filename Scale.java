
import java.awt.*;


public class Scale{
	// static doubleSCALEX = 0.8, SCALEY = 0.8;
	//毎回引数に渡すようにした。
	

	static MyImage execute(MyImage input, double scalex, double scaley) {
		int width1, height1, width2, height2, i, j;
		
		width1 = input.width;
		height1 = input.height;
		width2 = (int)(input.width * scalex);
		height2 = (int)(input.height * scaley);
		MyImage output = new MyImage(width2, height2);
	
		
		for(i = 0; i < height2; i++) {
			for(j = 0; j < width2; j++) {
				double x1, y1, r, g, b;
				
				x1 = calcX(j, i, width1, height1, scalex);
				y1 = calcY(j, i, width1, height1, scaley);

				calcRGB(input, output, x1, y1, j, i);

			}
		}

		return output;

	}

	
	static double calcX(int x2, int y2, int width1, int height1, double scalex) {
		double x = 0.0;

		x = x2 / scalex;

		if(x < 0.0 || x > (double)width1) {
			System.out.println("EXIT! x=" + x);
			System.exit(-1);
		}

		return x;
	}

	
	static double calcY(int x2, int y2, int width1, int height1, double scaley) {
		double y = 0.0;

		y = y2 / scaley;

		if(y < 0.0 || y > (double)height1) {
			System.out.println("EXIT! y=" + y);
			System.exit(-1);
		}

		return y;
	}




	static void calcRGB(MyImage input, MyImage output, double x1, double y1, int x2, int y2) {

		int xx = (int)(x1 + 0.5);
		if(xx < 0) xx = 0;
		if(xx >= input.width) xx = input.width - 1;
		int yy = (int)(y1 + 0.5);
		if(yy < 0) yy = 0;
		if(yy >= input.height) yy = input.height - 1;

		Color color = input.getColor(xx, yy);
		int value = color.getRGB();
		output.setColor(x2, y2, color);
	
	}

}
