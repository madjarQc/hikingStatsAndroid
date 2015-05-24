package madjar.hikingstats.hikingstats;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 20-05-15.
 */
public class Track extends Travel{

    private List<AlexPoints> listOfPoints = new ArrayList<>();

    /**
     * Construct single track from start to finish time
     * @param startTime
     * @param finishTime
     * @param listOfPoints 
     */
    public Track(DateTime startTime, DateTime finishTime, List listOfPoints) {
        setStartTime(startTime);
        setFinishTime(finishTime);
        this.listOfPoints = listOfPoints;
        setDistance(calculateDistance());
        setDuration(calculateDuration());
    }
    /**
     * TODO
     * Construct a track from its name in the DB and all the points in it.
     * Start and finish time will be the one of the track.
     * @param name, the name of the Track to find in DB
     */
    public Track(String name){
        
        //SQL query to get the start and finish time of the track
        setName(name);
        this.listOfPoints = getListOfPoints(name);
        
        
    }
    /**
     * To get the list of point from name
     * @param name
     * @return 
     */
    public List getListOfPoints(String name) {

        //SQL Query from name to get a list of point

        return listOfPoints;
    }

    public void setListOfPoints(List listOfPoints) {
        this.listOfPoints = listOfPoints;
    }
    
    @Override
    public double calculateDistance(){

        double distanceInMeter = 0;
        
        for(int i = 0; i < listOfPoints.size() - 1; i++){
            
            distanceInMeter += listOfPoints.get(i).distance(listOfPoints.get(i+1));
            
        }
        
        distanceInMeter = distanceInMeter * 10;

        return distanceInMeter;

    }

    @Override
    public double calculateDuration(){

        return (getFinishTime().getMillis() - getStartTime().getMillis()) / 1000;
    }

    public double calculateAvgMvSP(List listOfPoints){

        return 1;
    }

}
