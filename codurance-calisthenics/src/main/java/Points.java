
public class Points {
    public Points(int points) {
        this.points = points;
    }
    private int points;
    public static Points zero = new Points(0);
    @Override
    public int hashCode() {
        return points;
    }
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Points &&
                this.points == ((Points)obj).points;
    }
    
}
