package study.datajpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Member {
    @Id
    @GeneratedValue
    private Long id;
    private String username;

    protected Member() { // jpa 표준 스펙으로 기본적으로 필요한 생성자이다. protected 로 해야하는 이유는 프록시가 들어와야 할 수 있어서이다. private는 프록시가 못들어온다.
    }

    public Member(String username) {
        this.username = username;
    }


}
