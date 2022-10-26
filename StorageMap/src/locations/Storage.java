package locations;

public interface Storage {
    //Format of spots: x-coor (length), y-coor (width), z-coor (height)
    void list();
    void store();
    boolean find(String l, String s);
    void locate(String l, String s);
    void take(String l, String s);
}
