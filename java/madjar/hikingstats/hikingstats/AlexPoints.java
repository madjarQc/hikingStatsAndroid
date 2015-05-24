package madjar.hikingstats.hikingstats;

import org.joda.time.DateTime;

import javax.vecmath.Point3d;

/**
 *
 * @author Alex
 */
public class AlexPoints extends Point3d{

    DateTime date;
    double x;
    double y;
    double z;

    public AlexPoints(DateTime date, double x, double y, double z) {
        super(x, y, z);
        this.x = x;
        this.y = y;
        this.z = z;
        this.date = date;
    }
    
    /**
     * Constructor used to mark the start of a track
     * @param date, date of the first point - 1
     */
    public AlexPoints(DateTime date){
        super(0, 0, 0);
        //remove 1 millisecond to the time of the marker row
        this.date = date.minus(1);

    }
    
    public DateTime getDate(){
        
        return this.date;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
}
