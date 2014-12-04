import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;

public class SeaWorld extends World {

	final static int WIDTH = 900;
	final static int HEIGHT = 750;
	final static int CELLSIZE = 1;
	final static GreenfootImage BG=new GreenfootImage("images/space.png");

	final static Bullet testBullet=new Bullet(2,45,new GreenfootImage("images/BlueBullet.png"));
	final static Bullet testBullet1=new Bullet(2,135,new GreenfootImage("images/RedBullet.png"));
	final static Bullet testBullet2=new Bullet(2,225,new GreenfootImage("images/BlueBullet.png"));
	final static Bullet testBullet3=new Bullet(2,315,new GreenfootImage("images/RedBullet.png"));

	final static Bullet[] testBullets={testBullet, testBullet1, testBullet2, testBullet3};

	private Bullet ghostBullet=new Bullet(1,180,new GreenfootImage(1,1));
	private Bullet ghostBullet2=new Bullet(1,180,new GreenfootImage(1,1));

	private GameWorld world;

	private boolean isMenu;

	public SeaWorld(int level, GameWorld world){
		super(WIDTH,HEIGHT,CELLSIZE);
		this.world=world;

		Ship ship = new Ship();
		Life life = new Life();
		Score score = new Score();
		getBackground().drawImage(BG, 0, 0);

		this.addObject(ship, 450, 700);
		this.addObject(ghostBullet, 1, 1);
		this.addObject(ghostBullet2, 1, 1);
		this.addObject(life,500,730);
		this.addObject(score,100,730);

		makeLevel(level);
	}

	public void act(){
		if(isMenu){
			if("space".equals(Greenfoot.getKey())){
				Greenfoot.setWorld(world);
			}
		}else{
			if(getObjects(Bullet.class).size()==1){
				Greenfoot.setWorld(new SeaWorld(0, world));
			}
		}
	}

	private void makeLevel(int level){
		switch(level){
		default:
			getBackground().drawString("Level Complete!", WIDTH/2, HEIGHT/2);
			getBackground().drawImage(new GreenfootImage("Level Score : " + Score.getScore(), 24, Color.WHITE,new Color(0,0,0,0)), WIDTH/2, HEIGHT/2);
			isMenu=true;
			break;
		case 1:
			Spawner testSpawn=new Spawner(0,270,20,testBullets,new GreenfootImage("images/SpawnerDefault.png"));
			addObject(testSpawn, 450, 100);
			isMenu=false;
			break;
		case 2:
			isMenu=false;
			break;
		case 3: 
			isMenu=false;
			break;
		case 4:
			isMenu=false;
			break;
		case 5:
			isMenu=false;
			break;
		}
	}
}
