package hhpalvelinohjelmointi.Musicdb;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hhpalvelinohjelmointi.Musicdb.domain.User;
import hhpalvelinohjelmointi.Musicdb.domain.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {
	@Autowired
	private UserRepository userrepository;
	
	@Test
	public void findByUsernameShouldReturnAUser() {
		User user = userrepository.findByUsername("user");
		assertThat(user.getUsername()).isEqualTo("user");
	}
	
	@Test
	public void createNewUser() {
		User user1 = new User("Mikko", "Mikonsalasana123", "Testaaja");
		userrepository.save(user1);
		assertThat(user1.getId()).isNotNull();
	}
}
