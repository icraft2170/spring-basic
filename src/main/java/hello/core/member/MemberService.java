package hello.core.member;

public interface MemberService {
    public void joinMember(Member member);
    public Member findMember(Long memberId);
}
