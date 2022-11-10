package com.formacion.BS7_2.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

class ApiExceptionHandlerTest {
    /**
     * Method under test: {@link ApiExceptionHandler#hadlerEntytyNotFoutException(EntityNotFoundException)}
     */
    @Test
    void testHadlerEntytyNotFoutException() {
        ApiExceptionHandler apiExceptionHandler = new ApiExceptionHandler();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        ResponseEntity<CustomError> actualHadlerEntytyNotFoutExceptionResult = apiExceptionHandler
                .hadlerEntytyNotFoutException(new EntityNotFoundException("An error occurred", 1,
                        Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant())));
        assertTrue(actualHadlerEntytyNotFoutExceptionResult.hasBody());
        assertTrue(actualHadlerEntytyNotFoutExceptionResult.getHeaders().isEmpty());
        assertEquals(404, actualHadlerEntytyNotFoutExceptionResult.getStatusCodeValue());
        CustomError body = actualHadlerEntytyNotFoutExceptionResult.getBody();
        assertEquals(1, body.getHttpCode());
        assertEquals("An error occurred", body.getMessage());
    }

    /**
     * Method under test: {@link ApiExceptionHandler#hadlerEntytyNotFoutException(EntityNotFoundException)}
     */
    @Test
    void testHadlerEntytyNotFoutException2() {
        ApiExceptionHandler apiExceptionHandler = new ApiExceptionHandler();
        ResponseEntity<CustomError> actualHadlerEntytyNotFoutExceptionResult = apiExceptionHandler
                .hadlerEntytyNotFoutException(new EntityNotFoundException("An error occurred", 1, mock(java.sql.Date.class)));
        assertTrue(actualHadlerEntytyNotFoutExceptionResult.hasBody());
        assertTrue(actualHadlerEntytyNotFoutExceptionResult.getHeaders().isEmpty());
        assertEquals(404, actualHadlerEntytyNotFoutExceptionResult.getStatusCodeValue());
        CustomError body = actualHadlerEntytyNotFoutExceptionResult.getBody();
        assertEquals(1, body.getHttpCode());
        assertEquals("An error occurred", body.getMessage());
    }

    /**
     * Method under test: {@link ApiExceptionHandler#hadlerEntytyNotFoutException(EntityNotFoundException)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testHadlerEntytyNotFoutException3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.formacion.BS7_2.exception.EntityNotFoundException.getMessage()" because "e" is null
        //       at com.formacion.BS7_2.exception.ApiExceptionHandler.hadlerEntytyNotFoutException(ApiExceptionHandler.java:12)
        //   See https://diff.blue/R013 to resolve this issue.

        (new ApiExceptionHandler()).hadlerEntytyNotFoutException(null);
    }

    /**
     * Method under test: {@link ApiExceptionHandler#handleUnprocessableEntityException(UnprocessableEntityException)}
     */
    @Test
    void testHandleUnprocessableEntityException() {
        ApiExceptionHandler apiExceptionHandler = new ApiExceptionHandler();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        ResponseEntity<CustomError> actualHandleUnprocessableEntityExceptionResult = apiExceptionHandler
                .handleUnprocessableEntityException(new UnprocessableEntityException("An error occurred", 1,
                        Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant())));
        assertTrue(actualHandleUnprocessableEntityExceptionResult.hasBody());
        assertTrue(actualHandleUnprocessableEntityExceptionResult.getHeaders().isEmpty());
        assertEquals(422, actualHandleUnprocessableEntityExceptionResult.getStatusCodeValue());
        CustomError body = actualHandleUnprocessableEntityExceptionResult.getBody();
        assertEquals(1, body.getHttpCode());
        assertEquals("An error occurred", body.getMessage());
    }

    /**
     * Method under test: {@link ApiExceptionHandler#handleUnprocessableEntityException(UnprocessableEntityException)}
     */
    @Test
    void testHandleUnprocessableEntityException2() {
        ApiExceptionHandler apiExceptionHandler = new ApiExceptionHandler();
        ResponseEntity<CustomError> actualHandleUnprocessableEntityExceptionResult = apiExceptionHandler
                .handleUnprocessableEntityException(
                        new UnprocessableEntityException("An error occurred", 1, mock(java.sql.Date.class)));
        assertTrue(actualHandleUnprocessableEntityExceptionResult.hasBody());
        assertTrue(actualHandleUnprocessableEntityExceptionResult.getHeaders().isEmpty());
        assertEquals(422, actualHandleUnprocessableEntityExceptionResult.getStatusCodeValue());
        CustomError body = actualHandleUnprocessableEntityExceptionResult.getBody();
        assertEquals(1, body.getHttpCode());
        assertEquals("An error occurred", body.getMessage());
    }

    /**
     * Method under test: {@link ApiExceptionHandler#handleUnprocessableEntityException(UnprocessableEntityException)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testHandleUnprocessableEntityException3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.formacion.BS7_2.exception.UnprocessableEntityException.getMessage()" because "e" is null
        //       at com.formacion.BS7_2.exception.ApiExceptionHandler.handleUnprocessableEntityException(ApiExceptionHandler.java:18)
        //   See https://diff.blue/R013 to resolve this issue.

        (new ApiExceptionHandler()).handleUnprocessableEntityException(null);
    }
}

