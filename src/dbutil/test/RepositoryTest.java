package dbutil.test;

import domain.users.UserVO;
import repository.UsersDAOImpl;
import repository.Users;

public class RepositoryTest {
    private static Users rep = new UsersDAOImpl();
    public static void main(String[] args) {
        //test data
        UserVO testData = UserVO.builder()
        .userId("test111").userPw("testPw").userName("test111").userEmail("test111@naver.com").build();

        if(rep.userAdd(testData) != 0){
            System.out.println("성공");
        }else{
            System.out.println("실패");
        }

    }

}
