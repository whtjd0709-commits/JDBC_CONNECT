package dbutil.test;

import java.sql.Connection;
import java.sql.DriverManager; // Driver 대신 DriverManager를 사용해야 합니다.
import java.sql.PreparedStatement;
import java.sql.SQLException; // SQL 관련 예외 처리를 위해 필요합니다.

import domain.PersonVO;

public class DBInsertTest3 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "jdbcuser";
        String password = "jdbcuser";

        PersonVO vo = new PersonVO("user3", "user3Pw3", "user3", "user3@naver.com", 
                                   "02", "999-9999", (byte)28, "서울어딘가 ㅋㅋ", "강남구다..");

        // 1. Connection 객체 생성 (DriverManager 사용!)
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            
            // 2. SQL 작성 (PreparedStatement 방식: ? 사용)
            String sql = "insert into person (userId, userPw, userName, userEmail, phone1, phone2, age, address1, address2) "
                       + "values (?,?,?,?,?,?,?,?,?)";

            // 3. PreparedStatement 생성
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                // ? 자리에 데이터 채우기 (인덱스는 1부터 시작)
                pstmt.setString(1, vo.getUserId());
                pstmt.setString(2, vo.getUserPw());
                pstmt.setString(3, vo.getUserName());
                pstmt.setString(4, vo.getUserEmail());
                pstmt.setString(5, vo.getPhone1());
                pstmt.setString(6, vo.getPhone2());
                pstmt.setByte(7, vo.getAge());
                pstmt.setString(8, vo.getAddress1());
                pstmt.setString(9, vo.getAddress2());

                // 4. 실행 및 결과 확인
                int result = pstmt.executeUpdate();
                if(result != 0){
                    System.out.println("레코드 추가 성공");
                } else {
                    System.out.println("레코드 추가 실패..");
                }
            }
        } catch (SQLException e) { // Connection이나 PreparedStatement에서 발생하는 예외
            e.printStackTrace();                                   
        }
    }
}