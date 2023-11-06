package view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ChessImage {
private File fileImage;

public ChessImage() {
	super();
	this.fileImage = new File("D:\\CodeSpace\\JAVAPro\\ChessGame\\src\\Image\\chess.png\\");
}

public File getFileImage() {
	return fileImage;
}

public void setFileImage(File fileImage) {
	this.fileImage = fileImage;
}

public Image[] getImage(int lenght,int sizeImage) throws IOException {
	Image[] images = new Image[lenght];
	
	BufferedImage readImage = ImageIO.read(this.fileImage);

	int index = 0;
//Duyệt qua hình ảnh và cắt ra các icon
	for (int y = 0; y < 400; y += 200) {
		for (int x = 0; x < 1200; x += 200) {
			images[index] = readImage.getSubimage(x, y, 200, 200).getScaledInstance(sizeImage
					, sizeImage
					,
					BufferedImage.SCALE_SMOOTH);
			index++;
		}
	}

	
	return images;
}
}
