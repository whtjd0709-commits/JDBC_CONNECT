package domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
/*

Lombok에서 주로 사용하는 어노테이션...
:
    @setter/@getter : Getter/Setter 설정
    @Tostring : toString 메서드 생성.
    @EqualsAndHashCode : equals()와 hashCode() 메서드를 자동 구현.
    @Data : Getter,Setter,toString, equalsAndHashCode 어노테이션 기능을 모두 포함.
    @Builder : 복잡 객체 생성을 안정화하는 Builder 패턴을 자동 생성.

    @ALLArgConstructor : 멤버변수 전체를 사용하는 생성자를 만들어 줌.
    @NoArgConstructor  : 기본 생성자를 만들어 줌.
    
주의사항 : 
1) 무분별한 어노테이션의 사용으로 다른 기능과 연결되어 의도하지 않는 동작을 할 수 있음. (Data 어노테이션는 자중.)
2) @Builder만 사용하면 기본 생성자는 생성 X
    - @NoArgConstructor 사용하는게 일반적.
    - @ALLArgConstructor는 위에 @NoArgConstructor를 사용하는 경우에 같이 사용.
3) Lombok만 의존하면 문제 발생 시 대처 어렵. Lombok을 사용하지 못하는 경우에 대해서 대비할 필요있음.


*/
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder

public class PersonLom {

        //멤버 변수 선언
        private long id;
        private String userId;
        private String userPw;
        private String userName;
        private String userEmail;
        private String phone1;
        private String phone2;
        private byte age;
        private String address1;
        private String address2;
        private Timestamp regDate;
        private Timestamp modifyDate;
}
