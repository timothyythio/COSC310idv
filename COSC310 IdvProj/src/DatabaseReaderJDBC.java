import java.sql.*;
import java.util.ArrayList;
public class DatabaseReaderJDBC {
    public static String url = "jdbc:sqlserver://localhost;databaseName=products;TrustServerCertificate=True";	
	public static String uid = "sa";
	public static String pw = "304#sa#pw";   
    public static void main(String[] args) {	
        System.out.println(editProduct("Glass", "productId", "0"));
	}

    public static String[] viewProduct(String prod) {
        
        
        String[] resultData = new String[10];
        try ( Connection con = DriverManager.getConnection(url, uid, pw);
	              Statement stmt = con.createStatement(); ) 
		{
			String sql = "SELECT * from product WHERE productName = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, prod);
            ResultSet rst = pstmt.executeQuery();
            rst.next();
            for (int i = 0; i<=9; i++) {
                if (i == 0)
                    resultData[i] = "Product Info:";
                else 
                    resultData[i] = rst.getString(i);
            }

        }
		catch (SQLException ex)
		{
            return null;
		}
        return resultData;
    }

    public static int addProduct(String[] inputs) {

        try ( Connection con = DriverManager.getConnection(url, uid, pw);
	              Statement stmt = con.createStatement(); ) 
		{   
        
            String prodId = inputs[0];
            String prodName = inputs[1];
            String partNum = inputs[2];
            String prodLabel = inputs[3];
            String startInv = inputs[4];
            String invRec = inputs[5];
            String invShip = inputs[6];
            String invHand = inputs[7];
            String minReq = inputs[8];

			String sql ="INSERT INTO product VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, prodId);
            pstmt.setString(2, prodName);
            pstmt.setString(3, partNum);
            pstmt.setString(4, prodLabel);
            pstmt.setString(5, startInv);
            pstmt.setString(6, invRec);
            pstmt.setString(7, invShip);
            pstmt.setString(8, invHand);
            pstmt.setString(9, minReq);
            
            pstmt.executeQuery();

        }
		catch (SQLException ex)
		{
            System.err.println(ex);
            System.out.println(ex.getErrorCode());
            return ex.getErrorCode();
		}
        return 0;
    }

    public static int editProduct(String prod, String attr, String change) {
        try ( Connection con = DriverManager.getConnection(url, uid, pw);
	              Statement stmt = con.createStatement(); ) 
		{
            String sql2 = "UPDATE product SET "+attr+" = ? WHERE productName = ?";
            PreparedStatement pstmt = con.prepareStatement(sql2);
            pstmt.setString(1, change);
            pstmt.setString(2, prod);
            pstmt.executeUpdate();

        }catch (SQLException ex)
        {
            System.out.println(ex);
            return ex.getErrorCode();
        }
        return 0;
    }

    public static String[] prodList() {
        ArrayList<String> resultData = new ArrayList<>();
        try ( Connection con = DriverManager.getConnection(url, uid, pw);
	              Statement stmt = con.createStatement(); ) 
		{   

            String sql = "SELECT * FROM product";
            ResultSet rst = stmt.executeQuery(sql);
            while (rst.next()) {
                resultData.add(rst.getString(2));
            }

        }catch (SQLException ex)
        {
        System.out.println(ex.getErrorCode());
        return null;
        }
        String[] res = resultData.toArray(new String[0]);
        return res;
    }
}
