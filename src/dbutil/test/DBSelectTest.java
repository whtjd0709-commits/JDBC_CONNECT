package dbutil.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBSelectTest {
    public static void main(String[] args) {
        
        //1. Connection 연결 객체 생성 (DriverManager.getConection())
        //2. SQL 작성
        //3. Connection 객체에서 Statement 객체를 생성.
        //4. 생성된 Statement 객체를 이용해서 SQL을 실행.(Insert)
        //5. 이 후 작업이 있으면, 없으면 종료..

        //연결을 위한 정보
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "jdbcuser";
        String password = "jdbcuser";

        // 1. 객체 생성
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            //2. SQL 작성
            String sql = "Select *from person";

            //3.Statement 객체 생성, ResultSet 객체 생성 (Query 결과 받을 객체)
            Statement stmt = conn.createStatement();
            ResultSet rs = null;
            //4. SQL을 실행
            //Select의 실행은 executeQuery(sql)을 사용함
            //ResultSet 객체로 반환합니다
            rs = stmt.executeQuery(sql);
            //5. 결과 확인
            while (rs.next()){ //rs.next() 반환값은 boolean!!
                System.out.println("id : " +  rs.getLong("id"));
                System.out.println("userId : " +  rs.getString("userId"));
                System.out.println("userPw : " +  rs.getString("userPw"));
                System.out.println("userEmail : " +  rs.getString("userEmail"));
                System.out.println("age : " +  rs.getByte("age"));
                System.out.println("Phone : " +  rs.getString("phone1")
                            + "-" + rs.getString("phone2"));
                System.out.println("address1 : " +  rs.getString("address1"));
                System.out.println("address2 : " +  rs.getString("address2"));
                System.out.println("regDate : " +  rs.getTimestamp("regDate"));
                System.out.println("modifyDate : " +  rs.getTimestamp("modifyDate"));
            // }else{
                
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
