package br.com.igorg.massi.restfulAPISpringBoot.controllers;


import br.com.igorg.massi.restfulAPISpringBoot.converters.NumberConverter;
import br.com.igorg.massi.restfulAPISpringBoot.exception.UnsupportedMathOperationException;
import br.com.igorg.massi.restfulAPISpringBoot.services.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @Autowired
    private MathService mathService;

    @Autowired
    private NumberConverter numberConverter;

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )
            throws IllegalArgumentException {
        if (!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        return mathService.sum(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo));

    }

    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )
            throws IllegalArgumentException {
        if (!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        return mathService.subtraction(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo));


    }

    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )
            throws IllegalArgumentException {
        if (!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        return mathService.multiplication(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo));


    }

    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )
            throws IllegalArgumentException {
        if (!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        return mathService.division(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo));


    }

    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )
            throws IllegalArgumentException {
        if (!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        return mathService.mean(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo));


    }

    @RequestMapping("/squareRoot/{number}")
    public Double squareRoot(
            @PathVariable("number") String number
    )
            throws IllegalArgumentException {
        if (!numberConverter.isNumeric(number))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        return mathService.squareRoot(numberConverter.convertToDouble(number));

    }


}
