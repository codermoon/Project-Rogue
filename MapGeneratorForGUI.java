/* 
 
 Bu dosyan�n i�eri�ini GUI'yi �izen di�er classlara kopyalars�n�z. DummyRogueExec �ok kar���k geldi�i
 i�in buraya yazmay� uygun buldum.
 
 Buradaki metodlar�n/fieldlar�n hepsi ayn� class i�inde bulunmay� gerektirmeyebilir.
 
 */


import javax.swing.*;

public class MapGeneratorForGUI {
	
	Map map;
	int mapSize;
	int characterGraphicsX, characterGraphicsY;
	ImageIcon characterPNG, roomPNG, emptyRoomPNG, enemyPNG, goldPNG, trapPNG, swordPNG; 
	JLabel character, room, emptyRoom, enemy, gold, trap, sword;
	JLabel[][] mapLabel;
	JFrame frame; //bu stub JFrame'i kod hata vermesin diye koydum. Nesneleri draw etti�imiz frame'i bunun yerine yazar�z.
	
	public void executeThisVeryClass(){ //buradaki metodlar �u �ekilde/s�rada �al��mal�:
		initIMGIcons();
		initLabels();
		formLabelsWithIMGIcons();
		fixLabel(character); //ve di�er labellar i�in de ayn� �eyi uygulay�n
		initAndDrawMapGraphics();
		putStuffOnMapGraphics();
		placeCharacter();
	}
	
	public void initIMGIcons(){
		characterPNG = new ImageIcon("filepath yaz�n");
		roomPNG = new ImageIcon("filepath yaz�n");
		emptyRoomPNG = new ImageIcon("filepath yaz�n");
		enemyPNG = new ImageIcon("filepath yaz�n");
		goldPNG = new ImageIcon("filepath yaz�n");
		trapPNG = new ImageIcon("filepath yaz�n");
		swordPNG = new ImageIcon("filepath yaz�n");
	}
	
	public void initLabels(){
		character = new JLabel();
		room = new JLabel();
		emptyRoom = new JLabel();
		enemy = new JLabel();
		gold = new JLabel();
		trap = new JLabel();
		sword = new JLabel();
	}
	
	public void formLabelsWithIMGIcons(){
		character.setIcon(characterPNG);
		room.setIcon(roomPNG);
		emptyRoom.setIcon(emptyRoomPNG);
		enemy.setIcon(enemyPNG);
		gold.setIcon(goldPNG);
		trap.setIcon(trapPNG);
		sword.setIcon(swordPNG);
	}
	
	public void fixLabel(JLabel label){ //label'lar�n hepsini teker teker bu metoddan ge�irmek gerekli.
		label.setSize(label.getPreferredSize());
		label.setVisible(true);
	}
	
	public void initAndDrawMapGraphics(){
		map = new Map();
		int blockGap = 20; //bloklar�n aras�ndaki bo�luklar
		int xLoc = 100, yLoc = 100;
		mapSize = map.returnMapSize();
		mapLabel = new JLabel[mapSize][mapSize];
		for(int i = 0; i<mapSize; i++){
			for(int j = 0; j<mapSize; j++){
				mapLabel[i][j] = emptyRoom;
				mapLabel[i][j].setLocation(xLoc + (blockGap * i) , yLoc + (blockGap * j));
				frame.add(mapLabel[i][j], 0);
				frame.repaint();
			}
		}
	}
	
	public void putStuffOnMapGraphics(){
		for(int i = 0; i<mapSize; i++){
			for(int j = 0; j<mapSize; j++){
				if(map.mapArray[i][j].roomContent.equals("S")){ //e�er odada k�l�� var diye tan�mlad�ysak, di�er itemlar ve bo� oda i�in bir iki tane daha if laz�m
					mapLabel[i][j] = sword;
					frame.repaint();
				}
			}
		}
	}
	
	public void placeCharacter(){
		Player player = new Player();
		for(int i = 0; i<mapSize; i++){
			for(int j = 0; j<mapSize; j++){
				if(map.mapArray[i][j].roomContent.equals("0")){
					player.x = mapLabel[i][j].getX();
					player.y = mapLabel[i][j].getY();
					characterGraphicsX = player.x;
					characterGraphicsY = player.y;
					break;
				}
			}
		}
		character.setLocation(characterGraphicsX, characterGraphicsY); //normal �artlar alt�nda
		frame.add(character, 0);
		frame.repaint();
	}
	
}
