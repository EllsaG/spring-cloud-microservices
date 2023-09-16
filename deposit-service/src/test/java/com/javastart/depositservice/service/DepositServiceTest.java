package com.javastart.depositservice.service;

import com.javastart.deposit.controller.dto.DepositResponseDTO;
import com.javastart.deposit.exception.DepositServiceException;
import com.javastart.deposit.repository.DepositRepository;
import com.javastart.deposit.rest.AccountResponseDTO;
import com.javastart.deposit.rest.AccountServiceClient;
import com.javastart.deposit.rest.BillResponseDTO;
import com.javastart.deposit.rest.BillServiceClient;
import com.javastart.deposit.service.DepositService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class) // for using with "Mockito" testing
public class DepositServiceTest {

    @Mock // to set this class as endpoint, since no work will be done with repositories here
    private DepositRepository depositRepository;

    @Mock // to set this class as endpoint, since no work will be done with repositories here
    private AccountServiceClient accountServiceClient;

    @Mock // to set this class as endpoint, since no work will be done with repositories here
    private BillServiceClient billServiceClient;

    @Mock // to set this class as endpoint, since no work will be done with repositories here
    private RabbitTemplate rabbitTemplate;

    @InjectMocks // to set this class as testable
    private DepositService depositService;

    @Test // for set this method as test method
    public void depositServiceTest_withBillId() { // test to get "BillResponseDTO" and "AccountResponseDTO"
        BillResponseDTO billResponseDTO = createBillResponseDTO();
        Mockito.when(billServiceClient.getBillById(ArgumentMatchers.anyLong())).thenReturn(billResponseDTO); // when worked method "getBillById" it's return "billResponseDTO"
        AccountResponseDTO accountResponseDTO = createAccountResponseDTO();
        Mockito.when(accountServiceClient.getAccountById(ArgumentMatchers.anyLong())).thenReturn(accountResponseDTO); // when worked method "getBillById" it's return "accountResponseDTO"
        DepositResponseDTO deposit = depositService.deposit(null, 1L, BigDecimal.valueOf(1000));
        Assertions.assertThat(deposit.getMail()).isEqualTo("lori@cat.xyz");
    }

    @Test(expected = DepositServiceException.class) // for set this method as testing
    public void depositServiceTest_exception() { // test to get exception
        depositService.deposit(null, null, BigDecimal.valueOf(1000));
    }

    private AccountResponseDTO createAccountResponseDTO() { // to create instance of the "AccountResponseDTO"
        AccountResponseDTO accountResponseDTO = new AccountResponseDTO();
        accountResponseDTO.setAccountId(1L);
        accountResponseDTO.setBills(Arrays.asList(1L, 2L, 3L));
        accountResponseDTO.setCreationDate(OffsetDateTime.now());
        accountResponseDTO.setEmail("lori@cat.xyz");
        accountResponseDTO.setName("Lori");
        accountResponseDTO.setPhone("+1349831");
        return accountResponseDTO;
    }

    private BillResponseDTO createBillResponseDTO() { // to create instance of the "BillResponseDTO"
        BillResponseDTO billResponseDTO = new BillResponseDTO();
        billResponseDTO.setAccountId(1L);
        billResponseDTO.setAmount(BigDecimal.valueOf(1000));
        billResponseDTO.setBillId(1L);
        billResponseDTO.setCreationDate(OffsetDateTime.now());
        billResponseDTO.setIsDefault(true);
        billResponseDTO.setOverdraftEnabled(true);
        return billResponseDTO;
    }
}
