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

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
@DatabaseSetup("database-init.xml")
public class AccountRepository_FindAllWithOddId_Test
{
    @Autowired
    private AccountRepository accountRepository;

    private List<Account> accounts;
    private List<Account> allAccounts;


    @Before
    public void init()
    {
        this.accounts = accountRepository.findAllWithOddId();
        this.allAccounts = accountRepository.findAll();
    }

    @Test
    public void checkPresenceItems()
    {
        for (Account allAccount : this.allAccounts)
        {
            if (allAccount.getId() % 2 != 0)
            {
                assertThat(allAccount).isIn(this.accounts);
            }
        }
    }

    @Test
    public void checkAbsenceItems()
    {
        for (Account allAccount : this.allAccounts)
        {
            if (allAccount.getId() % 2 == 0)
            {
                assertThat(allAccount).isNotIn(this.accounts);
            }
        }
    }

}
