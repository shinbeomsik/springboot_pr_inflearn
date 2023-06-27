package hello.hellospring.repositroy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

class MemoryMemberRepositoryTest {

	MemoryMemberRepository repository = new MemoryMemberRepository();
	
	@AfterEach
	public void afterEach() {
		repository.cleatStore();
	}
	
	@Test
	public void save() {
		Member member = new Member();
		member.setName("spring");

		repository.save(member);

		Member result = repository.findById(member.getId()).get();
		assertThat(member).isEqualTo(result);

		// Assertions.assertEquals(member,result);
		// 이러한 방식도 있다 System.out.println("result = " + (result == member));
	}

	@Test
	public void findByName() {
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);

		Member result = repository.findByName("spring1").get();

		assertThat(result).isEqualTo(member1);

	}
	
	
	 @Test
	 public void findAll() {
	 //given
	 Member member1 = new Member();
	 member1.setName("spring1");
	 repository.save(member1);
	 Member member2 = new Member();
	 member2.setName("spring2");
	 repository.save(member2);
	 //when
	 List<Member> result = repository.findAll();
	 //then
	 assertThat(result.size()).isEqualTo(2);
	 }
}
