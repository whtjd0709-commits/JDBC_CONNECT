package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionTest2 {
    public static void main(String[] args) {
        //DB Connetion 작업을 직접 해보세요.

        //1. Connection 객체생성 

        /*2. 데이터베이스 접속 테스트 (try 사용)

            1)드라이버 로드

            2)Connection 객체 생성.



        */  
       Connection conn = null;


       try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이버 로드 성공입니다 !");

            conn = DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/jdbc"
                , "jdbcuser"
                , "jdbcuser");
                System.out.println(conn);
                System.out.println("데이터베이스 접속 성공입니다!");

       }catch(ClassNotFoundException e){
            System.out.println("드라이버 로드 실패...");
            
       }catch(SQLException sqle){
            System.out.println("SQL 에러발생 (데이터베이스 접속 실패~)");
       }finally{
        try{
            if(conn != null)
                conn.close();
        }catch(Exception e){

        }
       }
        

    }
}
