package locations;

public interface Storage {
    //Format of spots: x-coor (length), y-coor (width), z-coor (height)
    void store();
    void take(String s);
    boolean find(String l, String s);
    void locate(String l, String s);
}
