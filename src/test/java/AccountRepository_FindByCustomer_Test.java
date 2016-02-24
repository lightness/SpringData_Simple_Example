import com.aleshka.config.AppConfig;
import com.aleshka.domain.Account;
import com.aleshka.repository.AccountRepository;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import java.util.GregorianCalendar;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
@DatabaseSetup("database-init.xml")
public class AccountRepository_FindByCustomer_Test
{
    @Autowired
    private AccountRepository accountRepository;

    private List<Account> accounts;


    @Before
    public void init()
    {
        this.accounts = accountRepository.findByCustomer("Alex");
    }

    @Test
    public void checkSize()
    {
        assertThat(this.accounts).hasSize(1);
    }

    @Test
    public void foundEntityHasCorrectType()
    {
        assertThat(this.accounts.get(0)).isInstanceOf(Account.class);
    }

    @Test
    public void foundEntityHasCorrectFields()
    {
        assertThat(this.accounts.get(0).getId()).isEqualTo(1L);
        assertThat(this.accounts.get(0).getCustomer()).isEqualTo("Alex");
        assertThat(this.accounts.get(0).getExpiryDate()).isEqualTo(new GregorianCalendar(2010, 11, 31, 11, 5, 13));
    }


}
