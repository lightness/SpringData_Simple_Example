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

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
@DatabaseSetup("database-init.xml")
public class AccountRepository_FindAllByOrderByCustomerAsc_Test
{
    @Autowired
    private AccountRepository accountRepository;

    private List<Account> accounts;


    @Before
    public void init()
    {
        this.accounts = accountRepository.findAllByOrderByCustomerAsc();
    }

    @Test
    public void checkCount()
    {
        assertThat(this.accounts).hasSameSizeAs(accountRepository.findAll());
    }

    @Test
    public void checkOrder()
    {
        List<Account> allAccounts = accountRepository.findAll();
        Collections.sort(allAccounts, new AccountComparator());
        for (int i = 0; i < this.accounts.size(); i++)
        {
            assertThat(this.accounts.get(i)).isEqualTo(allAccounts.get(i));
        }
    }

    class AccountComparator implements Comparator<Account>
    {
        public int compare(
                Account o1,
                Account o2)
        {
            return o1.getCustomer().compareTo(o2.getCustomer());
        }
    }
}
