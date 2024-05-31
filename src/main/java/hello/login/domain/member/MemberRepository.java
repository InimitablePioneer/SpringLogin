package hello.login.domain.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor;

import javax.swing.text.html.Option;
import java.util.*;

@Slf4j
@Repository
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); //static
    private static long sequence = 0L; //static

    public Member save(Member member) {
        member.setId(++sequence);
        log.info("save: member={}", member);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public Optional<Member> findByLoninId(String loginId) {
//        List<Member> all = findAll();
//        for (Member member : all) {
//            if (member.getLoginId().equals(loginId)) {
//                return Optional.of(member);
//            }
//        }
//        return Optional.empty();
        return findAll().stream()
                .filter(m -> m.getLoginId().equals(loginId))
                .findFirst();

    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
