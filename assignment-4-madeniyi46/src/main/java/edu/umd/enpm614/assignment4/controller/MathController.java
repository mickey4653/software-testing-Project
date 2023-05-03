package edu.umd.enpm614.assignment4.controller;


import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
public class MathController {
    private static final String PLUS_VALUE = "plus";
    private static final String PLUS_SIGN = "+";
    private static final String MINUS_VALUE = "minus";
    private static final String MINUS_SIGN = "-";
    private static final String EQUAL_SIGN = "=";
    private static final String RESPONSE = "response";
    private static final String ERROR = "error";
    private static final String EXAMPLE_QUERY = "param1=2&param2=2&operator=" + PLUS_VALUE;
    private static final String EXAMPLE = "example";

    @GetMapping("/math")
    public String math(@RequestParam(name = "param1", required = false) String param1,
                       @RequestParam(name = "param2", required = false) String param2,
                       @RequestParam(name = "operator", required = false) String operator,
                       Model model) {
        try {
            Objects.requireNonNull(param1);
            Objects.requireNonNull(param2);
            Objects.requireNonNull(operator);
            int variableOne = Integer.parseInt(param1);
            int variableTwo = Integer.parseInt(param2);
            Operator operation = Operator.get(operator);
            int result = getResult(variableOne, variableTwo, operation);
            String response = param2 + operation.sign + param1 + EQUAL_SIGN + result;
            model.addAttribute(RESPONSE, response);
        } catch (NullPointerException npe) {
            model.addAttribute(ERROR, "Missing query parameters. Please add all parameters: 'param1', " +
                    "'param2', and 'operator'.");
            model.addAttribute(EXAMPLE, EXAMPLE_QUERY);
        } catch (NumberFormatException nfe) {
            model.addAttribute(ERROR, "Param1 and/or Param2 are not real numbers.");
            model.addAttribute(EXAMPLE, EXAMPLE_QUERY);
        } catch (IllegalArgumentException iae) {
            model.addAttribute(ERROR, "Invalid Operator was used. Try using 'plus' or 'minus'.");
            model.addAttribute(EXAMPLE, EXAMPLE_QUERY);
        }

        return "math";
    }

    private int getResult(@NonNull int param1, @NonNull int param2, @NonNull Operator operator) {
        switch (operator) {
            case PLUS:
                return param1 + param2;
            case MINUS:
                return param2 - param1;
            default:
                throw new IllegalArgumentException("Operator did not match known case");
        }
    }

    private enum Operator {
        PLUS(PLUS_SIGN), MINUS(MINUS_SIGN);
        private final String sign;

        Operator(String sign) {
            this.sign = sign;
        }

        private static Operator get(String operator) {
            Objects.requireNonNull(operator);
            switch (operator) {
                case PLUS_VALUE:
                    return PLUS;
                case MINUS_VALUE:
                    return MINUS;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }
}
