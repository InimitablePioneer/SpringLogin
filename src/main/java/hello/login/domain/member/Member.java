package hello.login.domain.member;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Member {

    private Long id;//시스템에서 쓰는 id 값

    @NotEmpty
    private String loginId; //로그인시 아이디
    @NotEmpty
    private String name;//사용자 이름
    @NotEmpty
    private String password;


}
