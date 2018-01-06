package io.github.frostqui.gui;

public class Font {

	private static SpriteSheet font = new SpriteSheet(8, "/font.png");
			
	private static Sprite[] characters = Sprite.split(font); // Sprite array of each character

	private static String charIndex = "ABCDEFGHIJKLM" + //
			"NOPQRSTUVWXYZ" + //
			".,-_" + //
			"0123456789" +  //
			"abcdefghijklmnopqrstuvwxyz";   //
			
			

	public Font() {
	}

	public void render(int x, int y, String text, Screen screen) {
		render(x, y, -3, 0xffffff, text, screen);
	}
	
	public void render(int x, int y, int spacing, int color, String text, Screen screen) {
		
		// Rendering each character and adjusting them to fit 
		
		int xOffset = 0;
		int line = 0;
		for (int i = 0; i < text.length(); i++) {
			xOffset += 8 + spacing;
			int yOffset = 0;
			char currentChar = text.charAt(i);
		
			if (currentChar == 'i') {
				xOffset -= 1;
			}
			
			
			
			if (currentChar == 'm') {
				xOffset += 1;
			}
			
			if (currentChar == 'w') {
				xOffset += 1;
			}
			
			
			
			
			
			
			
			if (currentChar == 'g' || currentChar == 'y' || currentChar == 'q' || currentChar == 'p' || currentChar == 'j' || currentChar == ',') {
				yOffset = 2;
				
			}
			if (currentChar == '\n') {
				xOffset = 0;
				line++;
			}
			
			int index = charIndex.indexOf(currentChar);
			
			
			
			if (index == -1) continue;
			screen.renderTextCharacter(x + xOffset, y + line * 20 + yOffset, characters[index], color, false);
		}
}
	
}