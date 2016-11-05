
import java.sql.*;   // Needed for JDBC classes
import java.util.Scanner;

/*Team 2
 * TeaARVIND SINGH RATHOD  213110090
 * Database creating file
 This program Will create a JavaDB and will also create 3 tables inside it that is  Room and Reservation
 */

/**
 *
 * @author SYSTEM
 */
public class RoomReservation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      // Create a named constant for the URL.
      // NOTE: This value is specific for Java DB.
      final String DB_URL = "jdbc:derby://localhost:1527//HotelDB1;create=true";
      
      try
      {
         // Create a connection to the database.
         Connection conn =DriverManager.getConnection(DB_URL);
	
         // If the DB already exists, drop the tables.
	dropTables(conn);
			
	// Build the Room table.
	buildRoomTable(conn);
			
	// Build the Reservation table.
	buildReservationTable(conn);
			
	buildGuestTable(conn);
        
        updatePrice( conn );
        
        
       
        // Close the connection.
         conn.close();
      }
      catch (Exception ex){
         System.out.println("ERROR: " + ex.getMessage());
      }  
    }//end main 
    
    
	/**
	 * The dropTables method drops any existing
	 * in case the database already exists.
	 */
	public static void dropTables(Connection conn)
	{
		System.out.println("Checking for existing tables.");
		
		try
		{
			// Get a Statement object.
			Statement stmt  = conn.createStatement();;

			try
			{
	         // Drop the UnpaidOrder table.
	         stmt.execute("DROP TABLE Room");
				System.out.println("Room table dropped.");
			}
			catch(SQLException ex)
			{
				// No need to report an error.
				// The table simply did not exist.
			}

			try
			{
	         // Drop the Customer table.
	         stmt.execute("DROP TABLE Reservation");
				System.out.println("Reservation table dropped.");				
			}
			catch(SQLException ex)
			{
				// No need to report an error.
				// The table simply did not exist.
			}

			try
			{
	         // Drop the Customer table.
	         stmt.execute("DROP TABLE Guest");
				System.out.println("Guest table dropped.");				
			}
			catch(SQLException ex)
			{
				// No need to report an error.
				// The table simply did not exist.
			}
		}
  		catch(SQLException ex)
		{
	      System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
    /**
	 * The buildRoomTable method creates the
	 * Room table and adds some rows to it.
	 */
	public static void buildRoomTable(Connection conn)
	{
            System.out.println("Creating the Room Table");
		try
		{
         // Get a Statement object.
         Statement stmt = conn.createStatement();
         
			// Create the table.
			stmt.execute("CREATE TABLE Room (" +
   		    "Room_Number CHAR(10) NOT NULL PRIMARY KEY, " +
                      "Num_of_Guests CHAR(8), " +
                      "CostperNight INT, " +
                      "RoomType CHAR(10), " +
                      "Status CHAR(15) " +          
                      ")");
							 
			// Insert row #1.
			stmt.execute("INSERT INTO Room VALUES ( " +
                      " '101', " +
                      " '2', " +
                      " 2500, "+
                      " 'Premier', "+
                      " 'Available' )" );

			// Insert row #2.
			stmt.execute("INSERT INTO Room VALUES ( " +
                      " '102', " +
                      " '2', " +
                      " 3500, "+
                      " 'Standard', "+
                      " 'Available' )" );

			// Insert row #3.
			stmt.execute("INSERT INTO Room VALUES ( " +
                      " '103', " +
                      " '2', " +
                      " 4500, "+
                      " 'Awesome', "+
                      " 'Not Available' )" );

			// Insert row #4.
			stmt.execute("INSERT INTO Room VALUES ( " +
                      " '104', " +
                      " '2', " +
                      " 4500, "+
                      " 'Awesome', "+
                      " 'Available' )" );

			// Insert row #5.
			stmt.execute("INSERT INTO Room VALUES ( " +
                      " '105', " +
                      " '3', " +
                      " 3500, "+
                      " 'Standard', "+
                      " 'Available' )" );

			// Insert row #6.
			stmt.execute("INSERT INTO Room VALUES ( " +
                      " '106', " +
                      " '3', " +
                      " 4500, "+
                      " 'Awesome', "+
                      " 'Available' )" );

                        // Insert row #7.
			stmt.execute("INSERT INTO Room VALUES ( " +
                      " '107', " +
                      " '3', " +
                      " 2500, "+
                      " 'Premier', "+
                      " 'Not Available' )" );

                        
                       // Insert row #8.
			stmt.execute("INSERT INTO Room VALUES ( " +
                      " '108', " +
                      " '4', " +
                      " 4500, "+
                      " 'Standard', "+
                      " 'Not Available' )" );

					 
		      // Insert row #9.
			stmt.execute("INSERT INTO Room VALUES ( " +
                      " '109', " +
                      " '4', " +
                      " 6500, "+
                      " 'Awesome', "+
                      " 'Available' )" );

                      // Insert row #10.
			stmt.execute("INSERT INTO Room VALUES ( " +
                      " '110', " +
                      " '4', " +
                      " 4000, "+
                      " 'Premier', "+
                      " 'Available' )" );
  
                      // Insert row #11.
			stmt.execute("INSERT INTO Room VALUES ( " +
                      " '111', " +
                      " '4', " +
                      " 6500,"+
                      " 'Standard', "+
                      " 'Available' )" );
                        
                        stmt.execute("INSERT INTO Room VALUES ( " +
                      " '112', " +
                      " '3', " +
                      " 3500, "+
                      " 'Standard', "+
                      " 'Available' )" );
  
                      // Insert row #11.
			stmt.execute("INSERT INTO Room VALUES ( " +
                      " '113', " +
                      " '4', " +
                      " 6500,"+
                      " 'Awesome', "+
                      " 'Available' )" );
                        
                        stmt.execute("INSERT INTO Room VALUES ( " +
                      " '114', " +
                      " '2', " +
                      " 2500, "+
                      " 'Premier', "+
                      " 'Available' )" );
  
                      // Insert row #11.
			stmt.execute("INSERT INTO Room VALUES ( " +
                      " '115', " +
                      " '3', " +
                      " 64500,"+
                      " 'Awesome', "+
                      " 'Available' )" );
                     
                     
                     
                        System.out.println("Room table created");// User Message
                       System.out.println();
                        System.out.println("Here is the Rooms Table....");
          System.out.println("Room Number         "+"Number of Guests        "+"Cost/Night        "+"Room Type        "+"Status");             
                ResultSet ar = stmt.executeQuery("SELECT Room_Number, Num_of_Guests, CostperNight, RoomType, Status FROM Room");// Displaying the data from table
                while(ar.next()){
                System.out.println("        "+ar.getString("Room_Number")+"             "+ar.getString("Num_of_Guests")+"           "+ar.getString("CostperNight")
                         +"           "+ar.getString("RoomType")+"      "+ar.getString("Status"));
                System.out.println();
                }
		}
		catch (SQLException ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
	}

	/**
	 * The buildReservationTable method creates the
	 * Customer table and adds some rows to it.
	 */
	public static void buildReservationTable(Connection conn)
	{
            System.out.println("Creating the Reservation table");
      try
      {
         // Get a Statement object.
         Statement stmt = conn.createStatement();
         
         // Create the table.
         stmt.execute("CREATE TABLE Reservation (" +
             "Reservation_Number CHAR(8), " +
            "  Room_Number CHAR(8) NOT NULL PRIMARY KEY,"    +
            "  Date_Reserved CHAR(15))");

         // Add some rows to the new table.
         stmt.executeUpdate("INSERT INTO Reservation VALUES (" +
               " '23221'," +
               " '101'," +
               "'19-01-2015')");
         
         stmt.executeUpdate("INSERT INTO Reservation VALUES (" +
               " '23222'," +
               " '102'," +
               "'20-01-2015')");
         
         stmt.executeUpdate("INSERT INTO Reservation VALUES (" +
               " '23223'," +
               " '103'," +
               "'22-01-2015')");
         
         stmt.executeUpdate("INSERT INTO Reservation VALUES (" +
               " '23224'," +
               " '104'," +
               "'25-01-2015')");
         
         stmt.executeUpdate("INSERT INTO Reservation VALUES (" +
               " '23225'," +
               " '106'," +
               "'30-01-2015')");
         
         stmt.executeUpdate("INSERT INTO Reservation VALUES (" +
               " '23226'," +
               " '107'," +
               "'19-01-2015')");
         
         stmt.executeUpdate("INSERT INTO Reservation VALUES (" +
               " '23227'," +
               " '108'," +
               "'20-01-2015')");
         
         stmt.executeUpdate("INSERT INTO Reservation VALUES (" +
               " '23228'," +
               " '110'," +
               "'22-01-2015')");
         
         stmt.executeUpdate("INSERT INTO Reservation VALUES (" +
               " '23229'," +
               " '111'," +
               "'25-01-2015')");
           
         stmt.executeUpdate("INSERT INTO Reservation VALUES (" +
               " '23230'," +
               " '112'," +
               "'22-01-2015')");
         
         stmt.executeUpdate("INSERT INTO Reservation VALUES (" +
               " '23231'," +
               " '113'," +
               "'25-01-2015')");
         
           
         stmt.executeUpdate("INSERT INTO Reservation VALUES (" +
               " '23232'," +
               " '114'," +
               "'22-01-2015')");
         
         stmt.executeUpdate("INSERT INTO Reservation VALUES (" +
               " '23233'," +
               " '115'," +
               "'25-01-2015')");
         
         
         
         
			System.out.println("Reservation table created.");//User Message
                       System.out.println();
                        System.out.println("Here is the Reservation Table....");
                System.out.println("Reservation Numbers    "+"Room Numbers     "+"Date Reserved");
         //Displaying the data from the Reservation Table
           ResultSet ar = stmt.executeQuery("SELECT Reservation_Number, Room_Number, Date_Reserved FROM Reservation");
          while(ar.next()){
          System.out.println("       "+ar.getString("Reservation_Number")+"               "+ ar.getString("Room_Number")+"      "+ ar.getString("Date_Reserved"));
          System.out.println();
                }
		}
		catch (SQLException ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
	}
        
        /**
	 * The buildGuestInformTable method creates the
	 * Customer table and adds some rows to it.
	 */
	public static void buildGuestTable(Connection conn)
	{
            System.out.println("Creating the Guest table");
      try
      {
         // Get a Statement object.
         Statement stmt = conn.createStatement();
         
         // Create the table.
         stmt.execute("CREATE TABLE Guest (" +
           " Room_Number CHAR(8) NOT NULL PRIMARY KEY,"    +
             "First_Name CHAR(20), " +
            "Last_Name CHAR(20) ,"    +
            "ID_Proof CHAR(20) ,"    +
            "ID_Num CHAR(20) ,"    +    
            "Address CHAR(20) ,"    +
             "Country CHAR(20) ,"    +     
            " Phone CHAR(20) ,"    +       
            " Email CHAR(20))");
         
          // Add some rows to the new table.
         stmt.executeUpdate("INSERT INTO Guest VALUES (" +
              " '103'," +
                 " 'Sam'," +
               " 'Martin'," +
               " 'Passport'," +
               " 'ok898989'," +
              " 'Anglo Street'," +
                " 'Austria'," +
                " '099889898'," +   
               "'sam.r@yahoo.in')");
         // Add some rows to the new table.
     
         stmt.executeUpdate("INSERT INTO Guest VALUES (" +
               " '107'," +
                 " 'Peter'," +
               " 'Jackson'," +
               " 'Passport'," +
               " 'k8PJ0389'," +
              " 'Comdown Street'," +
                " 'Belgium'," +
                " '986754323'," +   
               "'peter.j@yahoo.in')");
         
          stmt.executeUpdate("INSERT INTO Guest VALUES (" +
               " '108'," +
                 " 'Sonia'," +
               " 'Methan'," +
               " 'Passport'," +
               " 'GN980956'," +
              " 'Kongong Street'," +
                " 'Hongkong'," +
                " '986754004'," +   
               "'sonia.m@yahoo.in')");
     
         System.out.println("Guest table created.");//User Message
                       System.out.println();
                        System.out.println("Here is the Guest Table....");
                System.out.println("Room Number           First Name           "+"Last Name        "+"ID proof             "+"ID Number                   "+"Address           "+"country             "+"Phone no.               "+"Email");
         //Displaying the data from the Reservation Table
           ResultSet ar = stmt.executeQuery("SELECT Room_Number, First_Name, Last_Name, ID_Proof, ID_Num, Address, Country, Phone, Email FROM Guest");
          while(ar.next()){
          System.out.println("       "+ar.getString("Room_Number")+"       "+ar.getString("First_Name")+" "+ ar.getString("Last_Name")+" "+ ar.getString("ID_Proof")+" "+ ar.getString("ID_Num")+" "+ ar.getString("Address")+" "+ ar.getString("Country")+""+ ar.getString("Phone")+ ar.getString("Email"));
          System.out.println();
                }
		}
		catch (SQLException ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
	}
        
public static void updatePrice(Connection conn
                                  ) throws SQLException
   {System.out.println("Updating the rooms Price..... ");
     Scanner keyboard = new Scanner(System.in);
     
     Statement stmt  = conn.createStatement();  // Get a Statement object.
      int row=0;	
     System.out.print("Enter a positive no. to update the price of a room: ");
     int update = keyboard.nextInt();
        System.out.print("Enter the room number for updating the price: ");
         String RoomNumber = keyboard.next();
     
         while(update!=-1){
            
       
        System.out.print("Enter the new Price of this room: ");
           String Price = keyboard.next();
       // Create an UPDATE statement to update the price
      // for the specified product number.
      String sqlStatement = "UPDATE Room " +
                            "SET CostperNight = '" + Price +"'"+
                            "WHERE Room_Number = '" + RoomNumber + "'";
              row++;
      // Send the UPDATE statement to the DBMS.
      int rows = stmt.executeUpdate(sqlStatement);
       System.out.println("##Rooms price is update###" );   
      // Display the results.
      System.out.println();
      System.out.println("Enter any positive number to contunue updating the rooms price:  ");
        update = keyboard.nextInt();// To continue update the rooms price
      if(update!=-1){
        System.out.print("Enter the room number: ");
         RoomNumber = keyboard.next();
      } else{
            break;   }
           }
     System.out.printf("No. of rooms price updated %d\n",row);
        System.out.println("Here is the new updated Room Table");
        
        System.out.println("Room Number     "+"Number of Guests        "+"Cost/Night");             
                ResultSet ar = stmt.executeQuery("SELECT Room_Number, Num_of_Guests, CostperNight FROM Room");// Displaying the data from table
                while(ar.next()){
                System.out.println("        "+ar.getString("Room_Number")+"          "+ar.getString("Num_of_Guests")+"       "+ar.getString("CostperNight"));
                System.out.println();
                }
   }
  

}
