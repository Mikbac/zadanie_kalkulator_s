package com.service;

import com.salary.Salary;
import com.salary.strategies.SalaryPl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@WebMvcTest
public class CountryModelServiceTest {

    @MockBean
    CountryService countryService;

    @Test
    public void getExchangeRateWhenCountryCodeIsCorrect() throws Exception {
        Salary salary = new Salary();

        countryService.setStrategy(salary, new SalaryPl());

        BigDecimal ans = countryService.calculateSalary(salary, "PL", "123");

        BigDecimal wrong = new BigDecimal(0);
        org.junit.Assert.assertNotSame(wrong, ans);

    }
}