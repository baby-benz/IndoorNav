package UI.database.Entity.Point;

public class Point {

    public Integer id; //TODO private
    public Integer x; // private
    public Integer y; // private
    public String location = "null"; // private not null;

    public Point(Integer id, Integer x, Integer y, String location){
        this.id = id;
        this.x = x;
        this.y = y;
        this.location = location;
    }
}
