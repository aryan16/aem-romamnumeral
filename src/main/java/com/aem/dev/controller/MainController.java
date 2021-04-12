package com.aem.dev.controller;
import com.aem.dev.exception.MainAppException;
import com.aem.dev.model.RomanNumeralOutput;
import com.aem.dev.service.IntToRoman;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    private IntToRoman intToRoman;

    @Autowired
    public MainController(IntToRoman intToRoman) {
        this.intToRoman = intToRoman;
    }

    /**
     * this end point convert integer to the roman numeral and returns a json in the response
     * @param query : integer input
     * @return : JSON object
     * @throws MainAppException
     */
    @GetMapping(value = "/romannumeral", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RomanNumeralOutput> romanToIntRequestHandler(@RequestParam String query) throws MainAppException {
            try {
                int number = IntToRoman.validateInput(query);
                String romanValue = intToRoman.convertIntToRoman(number);
                RomanNumeralOutput romanNumeralOutput = new RomanNumeralOutput(query, romanValue);
                return new ResponseEntity<>(romanNumeralOutput, HttpStatus.OK);
            } catch (MainAppException ex) {
                logger.error("Problem with the input or intToRoman conversion method");
                throw new MainAppException(ex.getMessage());
            } catch (Exception e) {
                logger.error(e.getMessage());
                throw new MainAppException(e.getMessage());
            }
    }
}
