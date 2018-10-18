// 17 - 04 - 2018
package test;

/*

must add ===> "mysql-connector-java-5.1.46-bin.java" <=== Driver file for connection... 

############################################################################
create database students;

use students;

create table results ( sID int not null primary key AUTO_INCREMENT, sName varchar(15), sMark float(5,2), sFee double(8,2) );

############################################################################
desc results ;
+-------+-------------+------+-----+---------+---------------+
| Field | Type        | Null | Key | Default |     Extra     |
+-------+-------------+------+-----+---------+---------------+
| sID   | int(11      | NO   | PRI | NULL    | auto_incremen |
| sName | varchar(15) | YES  |     | NULL    |               |
| sMark | float(5,2)  | YES  |     | NULL    |               |
| sFee  | double(9,2) | YES  |     | NULL    |               |
+-------+-------------+------+-----+---------+---------------+

############################################################################

insert into results values (1 , "Alex", 92.58,   32000.45 );

insert into results(sName,sMark,sFee) values ("Jon", 95.24, 650000.45 ); 

insert into results(sName,sMark,sFee) values 
    ("Lera", 93.21,  650000.64 ) , 
    ("Sam",  94.86,  852140.64 ) , 
    ("Seen", 55.00,   10000.00 ) ; 

############################################################################

select * from results ;

Delete all row's from tables... 
truncate results ;

drop table results ;

update results set sName="Taiseen" where sID = 5  ;

update results set mark=100.00 where sid = 3 ;

############################################################################
*/

import java.sql.*;

public class DBConnection {

    //private static final String DRIVER = "com.mysql.jdbc.driver";
    private static final String URL = "jdbc:mysql://localhost:";
    private static final String PORT = "3306/";
    private static final String DB = "students";
    private static final String USER = "root";
    private static final String PASS = "";

    public static void main(String[] args) {
        //System.out.println("Hello........... \n");
        Connection con = null;
        Statement st = null;
        try {
            //Class.forName(DRIVER);
            con = DriverManager.getConnection(URL + PORT + DB, USER, PASS);

            String sql = "select * from results";

            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while ( rs.next() ) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                float mark = rs.getFloat(3);
                double fee = rs.getDouble(4) ;

                System.out.println("ID is : " + id);
                System.out.println("Name is : " + name);
                System.out.println("Mark is : " + mark);
                System.out.println("Fee is : " + fee);
                
                System.out.println( markSystem(mark) );
                System.out.println("-----------------------\n");
            }
            rs.close();
            System.out.println("#########################");
            System.out.println("ResultSet Object Close...\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String markSystem(float mark) {
        String result = null;

        if (100 >= mark && mark >= 80) {
            result = "Grade is : A+ \nRemarks : Outstanding";
        } else if (79 >= mark && mark >= 75) {
            result = "Grade is : A \nRemarks : Excellent";
        } else if (74 >= mark && mark >= 70) {
            result = "Grade is : A- \nRemarks : Very Good";
        } else if (69 >= mark && mark >= 65) {
            result = "Grade is : B+ \nRemarks : Good";
        } else if (64 >= mark && mark >= 60) {
            result = "Grade is : B \nRemarks : Satisfactory";
        } else if (59 >= mark && mark >= 55) {
            result = "Grade is : B- \nRemarks : Above Average";
        } else if (54 >= mark && mark >= 50) {
            result = "Grade is : C+ \nRemarks : Average";
        } else if (49 >= mark && mark >= 45) {
            result = "Grade is : C \nRemarks : Bellow Average";
        } else if (44 >= mark && mark >= 40) {
            result = "Grade is : D \nRemarks : Pass";
        } else if (39 >= mark && mark >= 00) {
            result = "Grade is : F \nRemarks : Fail";
        } else {
            result = "Your MARK is NOT valid!";
        }
        return result;
    }

}
