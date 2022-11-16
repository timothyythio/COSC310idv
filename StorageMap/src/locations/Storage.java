package locations;

public interface Storage {
    //Format of spots: x-coor (length), y-coor (width), z-coor (height)
    void list();
    void store(String barcode);
    boolean find(String storage, String barcode);
    void locate(String storage, String barcode);
    void take(String storage, String barcode);
}
