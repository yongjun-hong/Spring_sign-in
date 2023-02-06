package Spring.blog.repository;

import Spring.blog.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    //interface끼리 상속할때는 extends를 사용한다. 다중상속 가능
    @Override
    Optional<Member> findByName(String name);

}
