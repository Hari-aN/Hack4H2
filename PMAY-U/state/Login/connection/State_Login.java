package state.Login.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class is used to make the ULB Login
 * @author hari
 *
 */

public class State_Login {
    
    //References Declaration
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    //Constant String for JDBC 
    static final String DRIVER = "com.mysql.jdbc.Driver";
    static final String USER = "root";
    static final String PWD = "root";
    static final String CON_URL = "jdbc:mysql://localhost:3306/PMAY_U";
    
    //Query variables
    String sql = null;
    int counter = 0;
    
    /**
     * @author hari
     * 
     * Default constructor to establish connection with the database
     */
    public State_Login () {
        
        try{
            //STEP 1 - Load the Driver
            Class.forName (DRIVER);
            
            //STEP 2 - Establish the connection
            conn = DriverManager.getConnection(CON_URL, USER, PWD);
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
    }//end of constructor
    
    /////////////////////////////////////Retrieve data from database////////////////////////////////
    /**
     * 
     * This function is used to retrieve the data from the ULB_Login table
     * to edit it
     * 
     * @param ULB_ID and ULB_PASS
     * @return Object Of Type ResultSet
     */
    
    public ResultSet stateLogin(String USER_NAME, String PASS){

        sql = "SELECT STATE_DIGITAL_SIGN,OFFICER_NAME,STATE_NAME,OFFICER_EMAIL FROM STATE_LOGIN WHERE USER_ID = ? AND PASS = ?;";
        
        try {
           
            pstmt = conn.prepareStatement(sql);
            
                   
            pstmt.setString(1, USER_NAME);
            pstmt.setString(2, PASS);

            rs = pstmt.executeQuery();
            
            return rs;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rs;
    }//end of selectRecord4AEdit


}
