package BulletAnimation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
//xd
public class BulletMove extends Application 
{
	private static final double W = 800, H = 560;
    @Override
    public void start(Stage stage) throws Exception 
    {
    	BorderPane root = new BorderPane();
    	Scene scene = new Scene(root, W, H);
    	Circle c = new Circle();
    	c.setCenterX(420.0f); 
        c.setCenterY(300.0f); 
        c.setRadius(30.0f); 
    	double y = 0;
    	double x = randomWithRange(0, 500);
    	double a = 0;
    	double b = randomWithRange(0, 500);
    	double d = 0;
    	double e = randomWithRange(0, 500);
    	final Rectangle player = new Rectangle(400, 300, 50, 50);
    	final Rectangle zombie = new Rectangle(x, y, 50, 50);
    	final Rectangle zombie2 = new Rectangle(b, a, 50, 50);
    	final Rectangle zombie3 = new Rectangle(e, d, 50, 50);
    	c.setFill(Color.BLUE);
    	player.setFill(Color.BLACK);
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
    	timeline.setCycleCount(10);
    	timeline.setAutoReverse(false);
    	root.getChildren().add(c);
    	root.getChildren().add(player);
    	root.getChildren().add(zombie);
    	root.getChildren().add(zombie2);
    	root.getChildren().add(zombie3);
    	timeline.getKeyFrames().add(ac);
    	timeline.getKeyFrames().add(cx);
    	timeline.getKeyFrames().add(da);
    	timeline.getKeyFrames().add(bb);
    	timeline.play();
        stage.setScene(scene);
        stage.show();
        AnimationTimer timer = new AnimationTimer() 
        {
            public void handle(long now) 
            {
               
            }
        };
        timer.start();
    }
    public static void main(String[] args) 
    { 
    	launch(args); 
    }
    public int randomWithRange(int min, int max)
    {
    	int range = (max - min) + 1;     
    	return (int)(Math.random() * range) + min;
    }
}
