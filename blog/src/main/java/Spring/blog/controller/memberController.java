package Spring.blog.controller;

import Spring.blog.domain.Member;
import Spring.blog.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller //
public class memberController {

    private final MemberService memberService;

    @Autowired
    public memberController(MemberService memberService) {
        this.memberService = memberService;
    }
//Alt + Insert = 생성자 생성

    @GetMapping("/members/new") // 조회 할때는 주로 get을 사용한다.
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new") // 등록할때는 주로 post를 사용한다.
    public String Create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        return "redirect:/"; // redirect를 하면 create메소드가 끝나면 파라미터로 연결을 한다.

    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
