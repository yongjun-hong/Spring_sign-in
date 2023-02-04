package Spring.blog.repository;

import Spring.blog.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRespositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }
    @Test
    public void save(){
        Member member = new Member();
        member.setName("Spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get(); // Optional에서 값을 꺼낼때는 get으로 꺼낼수 있다.
//        Assertions.assertEquals(result,member); // True면 실행시켰을때 초록색이 나오고 오류면 빨간불이 나온다.
        assertThat(member).isEqualTo(result);
//        System.out.println("result = " + (result == member));
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member2 = new Member(); // shift + f6을 누르면 그 문단에 있는 변수의 이름이 전부 바뀐다.
        member2.setName("Spring2");
        repository.save(member2);

        Member result_Member = repository.findByName("Spring1").get();
        assertThat(result_Member).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
