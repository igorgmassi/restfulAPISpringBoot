package br.com.igorg.massi.restfulAPISpringBoot.controllers;


import br.com.igorg.massi.restfulAPISpringBoot.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
            )
            throws IllegalArgumentException{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");

        return  convertToDouble(numberOne) + convertToDouble(numberTwo);

    }
    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )
            throws IllegalArgumentException{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");

        return  convertToDouble(numberOne) - convertToDouble(numberTwo);

    }

    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )
            throws IllegalArgumentException{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");

        return  convertToDouble(numberOne) * convertToDouble(numberTwo);

    }
    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )
            throws IllegalArgumentException{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");

        return  convertToDouble(numberOne) / convertToDouble(numberTwo);

    }
    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )
            throws IllegalArgumentException{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");

        return  (convertToDouble(numberOne) + convertToDouble(numberTwo))/2;

    }
    @RequestMapping("/squareRoot/{number}")
    public Double squareRoot(
            @PathVariable("number") String numberOne,
    )
            throws IllegalArgumentException{
        if(!isNumeric(numberOne)) throw new UnsupportedMathOperationException("Please set a numeric value!");

        return  Math.sqrt(convertToDouble(numberOne)) ;

    }

    private Double convertToDouble( String strNumber) throws IllegalArgumentException{
        if( strNumber.isEmpty())  throw new UnsupportedMathOperationException("Please set a numeric value!");
        String number = strNumber.replace(",", ".");

        return Double.parseDouble(number);
    }
    private boolean isNumeric (String strNumber) throws IllegalArgumentException{
        if( strNumber.isEmpty()) throw new IllegalArgumentException();
        String number = strNumber.replace(",", ".");

        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }


}
