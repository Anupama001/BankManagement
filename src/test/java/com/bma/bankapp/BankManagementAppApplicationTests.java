package com.bma.bankapp;


import com.bma.bankapp.Service.AccService;
import com.bma.bankapp.entity.Account;
import com.bma.bankapp.repo.AccRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;


import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BankManagementAppApplicationTests {

	@Test
	void testAddition() {
		int result = 2 + 3;
		assertEquals(5, result);
	}
	@Autowired
	private AccService accService;
	@MockBean
	private AccRepo accRepo;

	@Test
	public void getAccTest(){
		when(accRepo.findAll()).thenReturn(Stream.of(new Account("Manu", 1800.0),new Account("anu", 1500.0)).collect(Collectors.toUnmodifiableList()));
		assertEquals(2,accService.getAllAcc().size());
	}

}
