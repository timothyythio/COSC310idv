package locations;

public interface Storage {
    //Format of spots: x-coor (length), y-coor (width), z-coor (height)
    void store();
    void take();
    void find();
}
