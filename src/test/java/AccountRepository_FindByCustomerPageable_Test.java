import com.aleshka.config.AppConfig;
import com.aleshka.domain.Account;
import com.aleshka.repository.AccountRepository;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
public class AccountRepository_FindByCustomerPageable_Test
{
    @Autowired
    private AccountRepository accountRepository;


    @Test
    public void testPageWithData()
    {
        Page<Account> accounts = accountRepository.findByCustomer("Alex", new PageRequest(0, 5));
        assertThat(accounts).hasSize(1);
        assertThat(accounts.getTotalElements()).isEqualTo(1);
        assertThat(accounts.getTotalPages()).isEqualTo(1);
        assertThat(accounts.getNumber()).isEqualTo(0);
        assertThat(accounts.getNumberOfElements()).isEqualTo(1);
        assertThat(accounts.getSize()).isEqualTo(5);
        assertThat(accounts.getSort()).isNull();
        Account account = accounts.getContent().get(0);
        assertThat(account.getCustomer()).isEqualTo("Alex");
        assertThat(account.getId()).isEqualTo(1);
        assertThat(account.getExpiryDate()).isEqualTo(new GregorianCalendar(2010, 11, 31, 11, 5, 13));
    }

    @Test
    public void testPageWithNoData()
    {
        Page<Account> accounts = accountRepository.findByCustomer("Alex", new PageRequest(1, 5));
        assertThat(accounts).hasSize(0);
        assertThat(accounts.getTotalElements()).isEqualTo(1);
        assertThat(accounts.getTotalPages()).isEqualTo(1);
        assertThat(accounts.getNumber()).isEqualTo(1);
        assertThat(accounts.getNumberOfElements()).isEqualTo(0);
        assertThat(accounts.getSize()).isEqualTo(5);
        assertThat(accounts.getSort()).isNull();
    }

    @Test
    public void testPageWithEmptyData()
    {
        Page<Account> accounts = accountRepository.findByCustomer("Absence", new PageRequest(0, 1));
        assertThat(accounts).hasSize(0);
        assertThat(accounts.getTotalElements()).isEqualTo(0);
        assertThat(accounts.getTotalPages()).isEqualTo(0);
        assertThat(accounts.getNumber()).isEqualTo(0);
        assertThat(accounts.getNumberOfElements()).isEqualTo(0);
        assertThat(accounts.getSize()).isEqualTo(1);
        assertThat(accounts.getSort()).isNull();
    }

}
