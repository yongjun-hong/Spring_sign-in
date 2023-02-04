package Spring.blog.service;

import Spring.blog.domain.Member;
import Spring.blog.repository.MemberRepository;
import Spring.blog.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//@Service // Service를 넣으면 Spring이 자동적으로 MemeberService를 컨테이너에 넣어준다.
public class MemberService {
    private final MemberRepository memberRepository;
//    @Autowired // Aurowired가 있으면 Repository가 필요한 것을 Spring이 알아챈다.
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원가입
    public long join(Member member) { // Optional이 있으면 좋지 않아서 = 가지 없애고 findByName에 바로 ifPresent를 붙일수 있다
        validuateDupilcateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validuateDupilcateMember(Member member) {
        memberRepository.findByName(member.getName()) // ctrl + alt + v하면 자동으로 객체 생성
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
