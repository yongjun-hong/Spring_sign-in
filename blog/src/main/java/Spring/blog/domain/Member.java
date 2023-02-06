package Spring.blog.domain;

import jakarta.persistence.*;

//jpa는 인터페이스만 제공한다. 구현체로 hibernate로 사용한다. 우리는 jpa의 hibernate를 사용한다.
@Entity // 이제부터 jpa가 관리하는 클래스
public class Member {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY) // db가 알아서 생성해주기 때문에 Genenration.Type를 INDENTITY로 한다.
    private long id;

    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
