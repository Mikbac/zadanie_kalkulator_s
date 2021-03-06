/**
 * Created by MikBac on 19.08.2019
 */

package pl.MikBac.salaryApp.spring.controller;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.MikBac.salaryApp.exception.CountryNotFoundException;
import pl.MikBac.salaryApp.exception.InvalidApiAddressException;
import pl.MikBac.salaryApp.exception.InvalidSalaryFromClientException;

import javax.annotation.Resource;
import java.util.Locale;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Resource
    private MessageSource messageSource;

    @ExceptionHandler(CountryNotFoundException.class)
    @ResponseBody
    public ResponseEntity<Object> countryNotFoundException(final Locale locale) {
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE)
                .body(messageSource.getMessage("error.country.not.found.text", null, locale));
    }

    @ExceptionHandler(InvalidApiAddressException.class)
    @ResponseBody
    public ResponseEntity<Object> invalidApiAddressException(final Locale locale) {
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE)
                .body(messageSource.getMessage("error.invalid.api.address.text", null, locale));
    }

    @ExceptionHandler(InvalidSalaryFromClientException.class)
    public ResponseEntity<Object> invalidSalaryFromClientException(final Locale locale) {
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE)
                .body(messageSource.getMessage("error.invalid.salary.from.client.text", null, locale));
    }
}

