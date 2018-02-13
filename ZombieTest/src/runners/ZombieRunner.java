package runners;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import Characters.Player;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
 //Yiren,Derek,leon,hoilam
public class ZombieRunner extends Application {
	
	Scene SceneMenu, SceneShop, SceneGame, SceneSave, SceneLoad;
	private double previousangle;
	private boolean playing=false;
	private static final double W = 800, H = 560;
	
    public static void main(String[] args) throws IOException {
	    	
		/*StringBuilder sb=new StringBuilder();
		System.out.println("High Score List");  	
    	String csvFile ="highscore.csv";
    	BufferedReader br = null;
    	br = new BufferedReader(new FileReader(csvFile));
    	String line="";
    	
    	while ((line = br.readLine()) != null)
    	{
            // use comma as separator
    		 String[] board = line.split(",");
             System.out.println(board[0]+ "  "+board[1]);
            sb.append(board[0]+ ","+board[1]+"\n");
        }
    	//
    	PrintWriter pw=new PrintWriter(new File("highscore.csv"));*/
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
    	
    	//****************SCENE MENU*****************************
    	StackPane startpg = new StackPane();
    	
    	Button btnstart = new Button("PLAY");
    	btnstart.setOnAction(e->primaryStage.setScene(SceneGame));
    	btnstart.setTranslateY(0);
    	btnstart.setFont(Font.loadFont("file:WarWound.otf",40));
    	
    	Button btnsave = new Button("SAVE");
    	//btnsave.setOnAction(e->primaryStage.setScene(SceneSave));
    	btnsave.setFont(Font.loadFont("file:WarWound.otf",40));
    	btnsave.setTranslateY(60);
    	
    	Button btnload = new Button("LOAD");
    	//btnload.setOnAction(e->primaryStage.setScene(SceneLoad));
    	btnload.setFont(Font.loadFont("file:WarWound.otf",40));
    	btnload.setTranslateY(120);

    	Button btnshop = new Button("SHOP");
    	btnshop.setOnAction(e->primaryStage.setScene(SceneShop));
    	btnshop.setFont(Font.loadFont("file:WarWound.otf",40));
    	btnshop.setTranslateY(180);
    	
    	   
        FileInputStream input = new FileInputStream("camo.jpg");
        Image Image = new Image(input);
        ImageView camo = new ImageView(Image);
        camo.setFitHeight(500);
        camo.setFitWidth(500);
        startpg.getChildren().addAll(camo,btnstart,btnsave,btnload,btnshop); 
    
    	SceneMenu = new Scene(startpg,500,500);
    	SceneMenu.getStylesheets().add("SceneMenu.css");
    	// ****************SCENE GAME*****************************
    	Pane game=new Pane();
    	game.setStyle("-fx-background-color: BLACK;");
    	Player player = new Player(100,250,250,1,100,1);
    	
    	Line line = new Line(); 
    	line.setStartX(500); 
    	line.setStartY(0); 
    	line.setEndX(500); 
    	line.setEndY(500);
    	line.setStroke(Color.AQUA);
    	line.setStrokeWidth(5);
    	
    	
    	Button btnpause = new Button("Pause");
        btnpause.setOnAction(e->
        {
        	//stop the game 
        });
        btnpause.setFont(Font.loadFont("file:WarWound.otf",30));
        btnpause.setStyle("-fx-padding:5;");
        btnpause.setTranslateX(530);
        btnpause.setTranslateY(100);
        
        Button btngameshop = new Button("SHOP");
    	btngameshop.setOnAction(e->primaryStage.setScene(SceneShop));
    	btngameshop.setFont(Font.loadFont("file:WarWound.otf",30));
    	btngameshop.setStyle("-fx-padding:5;");
    	btngameshop.setTranslateX(537);
    	btngameshop.setTranslateY(200);
    	
    	Rectangle rect = new Rectangle(50,10, Color.RED);
        rect.setX(245);
    	rect.setY(245);
        
        Circle c1 = new Circle(250,250,20);
    	c1.setFill(Color.WHITE);
    	game.getChildren().addAll(rect,c1,btnpause,btngameshop,line);
    	
    	SceneGame = new Scene(game,650,500);
    	
    	btnstart.setOnAction(new EventHandler<ActionEvent>() 
    	{
    		public void handle(ActionEvent e)
    		{    	        
    	        primaryStage.setScene(SceneGame);
    	        primaryStage.show();
    	        /*following code is modified from
    	         * https://gist.github.com/bugabinga/9636541
    	         */
    	        game.setOnMouseMoved(moved ->
    	        {
    	        	if(moved.getX()<=500)
    	        	{
    	        	Point2D mousepoint= new Point2D(moved.getX(), moved.getY());
    	        	double anglemove=computeAngle(mousepoint);

    	        	previousangle=anglemove;
    	        	rect.getTransforms().clear();
    	        	rect.getTransforms().add(new Rotate(anglemove,250,250));
    	        	}
    	        });
    	        game.setOnMouseDragged(dragged ->
    	        {
    	        	if(dragged.getX()<=500)
    	        	{
    	        	Point2D mousepoint= new Point2D(dragged.getX(), dragged.getY());
    	        	double anglemove=computeAngle(mousepoint);

    	        	previousangle=anglemove;
    	        	rect.getTransforms().clear();
    	        	rect.getTransforms().add(new Rotate(anglemove,250,250));
    	        	}
    	        });
    		}
    	});
    	
    	// ****************SCENE SAVE*****************************
    	
    	// ****************SCENE LOAD*****************************
    	
    	//****************SCENE_SHOP*****************************
    	StackPane sshop = new StackPane();
	    Image auto = new Image("Auto.png");
			ImageView iAuto = new ImageView();
			iAuto.setImage(auto);
		Image boomerang = new Image("Boomerang.png");
	    	ImageView iBoomerang = new ImageView();
	        iBoomerang.setImage(boomerang);
		Image click = new Image("Click.png");
	    	ImageView iClick = new ImageView();
	        iClick.setImage(click);
		Image poison = new Image("Poison.png");
	    	ImageView iPoison = new ImageView();
	        iPoison.setImage(poison);
		Image spear = new Image("Spear.png");
	    	ImageView  iSpear = new ImageView();
	        iSpear.setImage(spear);
		Image best = new Image("Best.png");
	    	ImageView iBest = new ImageView();
	        iBest.setImage(best);
        
        ImageView[] weaponimage = new ImageView[6];
        weaponimage[0] = iAuto;
        weaponimage[1] = iBoomerang;
        weaponimage[2] = iClick;
        weaponimage[3] = iPoison;
        weaponimage[4] = iSpear;
        weaponimage[5] = iBest;
        
        for(int i = 0; i < weaponimage.length; i++)
        {
        	weaponimage[i].setFitHeight(80);
        	weaponimage[i].setPreserveRatio(true);
            weaponimage[i].setSmooth(true);
            weaponimage[i].setCache(true);
        }
        
    	HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.CENTER); // default TOP_LEFT
        
        VBox vbox1 = new VBox(10);
        vbox1.setAlignment(Pos.CENTER_LEFT);
        vbox1.setStyle("-fx-border-style: dotted;"
                + "-fx-border-width: 1;"
                + "-fx-border-color: black");
        
        VBox vbox2 = new VBox(20);
        vbox2.setAlignment(Pos.CENTER_LEFT);
        vbox2.setStyle("-fx-border-style: dotted;"
                + "-fx-border-width: 1;"
                + "-fx-border-color: black");
    
        
        Button btnmenu = new Button("MENU");
	        btnmenu.setTranslateX(150);
	        btnmenu.setTranslateY(200);
	        btnmenu.setOnAction(e->primaryStage.setScene(SceneMenu));
        
        Label title = new Label("Weapons Shop");
        	title.setTranslateY(-200);
        	title.setFont(Font.loadFont("file:WarWound.otf",30));
        Label gold = new Label("Gold: " + player.getGold());
        	gold.setTranslateY(-100);
        	gold.setTranslateX(150);
        	gold.setFont(Font.loadFont("file:WarWound.otf",30));
        
        MenuButton btnAuto = new MenuButton("",iAuto);      	
	        MenuItem miA = new MenuItem("Click Here to BUY\nGold: 0\n AUTO\n  Shoots out multiple bullets");
	        btnAuto.getItems().add(miA);
        MenuButton btnClick = new MenuButton("",iClick);
	        MenuItem miC = new MenuItem("Click Here to BUY\nGold: 0\n CLICK\n  des");
	        btnClick.getItems().add(miC);
        MenuButton btnBoomerang = new MenuButton("",iBoomerang);
	        MenuItem miB = new MenuItem("Click Here to BUY\nGold: 0\n BOOMERANG\n  des");
	        btnBoomerang.getItems().add(miB);
        MenuButton btnPoison = new MenuButton("",iPoison);
	        MenuItem miP = new MenuItem("Click Here to BUY\nGold: 0\n POISON\n  des");
	        btnPoison.getItems().add(miP);
        MenuButton btnSpear = new MenuButton("",iSpear);
	        MenuItem miS = new MenuItem("Click Here to BUY\nGold: 0\n SPEAR\n  des");
	        btnSpear.getItems().add(miS);
        MenuButton btnBest = new MenuButton("",iBest);
	        MenuItem miBest = new MenuItem("Click Here to BUY\nGold: 999,999,999,999,999,999,999\n BESTTTTTTT\n  TYLER1 POWER");
	        btnBest.getItems().add(miBest);
     
        vbox1.getChildren().addAll(btnAuto, btnClick, btnSpear);
        	vbox1.setMaxSize(35, 300);
        	vbox1.setTranslateX(-80);
        vbox2.getChildren().addAll(btnPoison, btnBoomerang, btnBest);	
        	vbox2.setMaxSize(35, 300);
        	vbox2.setTranslateX(-80);
        
        hbox.getChildren().addAll(vbox1, vbox2);
        sshop.getChildren().addAll(title,gold,hbox,btnmenu);
        SceneShop = new Scene(sshop,500,500);
        SceneShop.getStylesheets().add("SceneShop.css");
    	//****************SCENE SHOP*****************************
    	    
    	//PRIMARY STAGE
        // THE BULLET ANIMATION
        primaryStage.setScene(SceneShop);
        primaryStage.show();
        primaryStage.setTitle("ZombieRush");
        BorderPane root = new BorderPane();
    	Scene scene = new Scene(root, W, H);
    	Circle c = new Circle();
    	c.setCenterX(250.0f); 
        c.setCenterY(200.0f); 
        c.setRadius(30.0f); 
    	double y = 0;
    	double x = randomWithRange(0, 500);
    	double a = 0;
    	double b = randomWithRange(0, 500);
    	double d = 0;
    	double e = randomWithRange(0, 500);
    	final Rectangle player1 = new Rectangle(400, 300, 50, 50);
    	// zombies
    	final Rectangle zombie = new Rectangle(x, y, 50, 50);
    	final Rectangle zombie2 = new Rectangle(b, a, 50, 50);
    	final Rectangle zombie3 = new Rectangle(e, d, 50, 50);
    	c.setFill(Color.BLUE);
    	player1.setFill(Color.BLACK);
    	zombie.setFill(Color.GREEN);
    	zombie2.setFill(Color.GREEN);
    	zombie3.setFill(Color.GREEN);
    	final KeyValue ab = new KeyValue(c.centerYProperty(),-500);
    	final KeyFrame ac = new KeyFrame(Duration.millis(1000), ab);
    	final KeyValue cz = new KeyValue(zombie.yProperty(), 500);
    	final KeyFrame cx = new KeyFrame(Duration.millis(1000), cz);
    	final KeyValue dc = new KeyValue(zombie2.yProperty(),400);
    	final KeyFrame da = new KeyFrame(Duration.millis(1000), dc);
    	final KeyValue ba = new KeyValue(zombie3.yProperty(),400);
    	final KeyFrame bb = new KeyFrame(Duration.millis(1000), ba);
    	final Timeline timeline = new Timeline();
    	timeline.setCycleCount(100);
    	timeline.setAutoReverse(false);
    	game.getChildren().add(c);
    	game.getChildren().add(player1);
    	game.getChildren().add(zombie);
    	game.getChildren().add(zombie2);
    	game.getChildren().add(zombie3);
    	timeline.getKeyFrames().add(ac);
    	timeline.getKeyFrames().add(cx);
    	timeline.getKeyFrames().add(da);
    	timeline.getKeyFrames().add(bb);
    	timeline.play();
      //  primaryStage.setScene(SceneMenu);
       // primaryStage.show();
    	
        primaryStage.setScene(SceneMenu);
        primaryStage.show();
        AnimationTimer timer = new AnimationTimer() 
        {
            public void handle(long now) 
            {
            	game.setOnMouseClicked( clicked ->
        		{
        			timeline.play();
        		});
            }
        };
        timer.start();
    }  
    private double computeAngle( final Point2D a )
    {
      final double angle1 = Math.toDegrees(Math.atan2(-(a.getX()-250), a.getY()-250));
      return angle1+90;
    }
    public int randomWithRange(int min, int max)
    {
    	int range = (max - min) + 1;     
    	return (int)(Math.random() * range) + min;
    }
}
