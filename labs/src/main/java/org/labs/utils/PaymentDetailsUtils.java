package org.labs.utils;

import lombok.experimental.UtilityClass;
import org.labs.exception.FieldsAndReason;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

import java.net.URI;
import java.util.List;

@UtilityClass
public class PaymentDetailsUtils {
    public static ProblemDetail getValidationErrors(List<FieldsAndReason> validationErrors) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Request validation failed");

        problemDetail.setTitle("Field Validation Exception");
        problemDetail.setType(URI.create("field-validation-error"));
        problemDetail.setProperty("invalids Params", validationErrors);

        return problemDetail;
    }
}
