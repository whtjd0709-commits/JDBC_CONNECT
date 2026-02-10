package repository;

import java.util.Optional;

import domain.users.UserVO;

public interface Users {
    int userAdd(UserVO user);

    // 레코드 수정
    int userMod(UserVO befor, UserVO after);
    int userMod(UserVO userVO);

    // 레코드 삭제
    int userDel(UserVO user);
    
    // 전체 조회
    java.util.List<UserVO> userAll();

    Optional<UserVO> login(String userId, String userPw);

    // 검색 (아이디+이름)
    java.util.List<UserVO> userSearch(String userId, String userName);

    // 검색 (이메일)
    java.util.Optional<UserVO> userSearch(String userEmail);
}
