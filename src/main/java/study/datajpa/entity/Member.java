package study.datajpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@ToString(of = {"id","username","age"})
public class Member {
    @Id
    @GeneratedValue
    @Column(name ="member_id")
    private Long id;
    private String username;

    private int age;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;


    public Member(String username) {
        this.username = username;
    }

    public void chnageTeam(Team team){
        this.team = team;
        team.getMembers().add(this);
    }

    public Member(String username, int age, Team team) {
        this.username = username;
        this.age = age;
        if(team!=null) {
            chnageTeam(team);
        }
    }
}
