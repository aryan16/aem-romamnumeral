package com.aem.dev.service;
import com.aem.dev.controller.MainController;
import com.aem.dev.exception.MainAppException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class IntToRoman {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);
    final static int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    final static String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};


    /**
     * this method converts integer to roman
     * @param number : integer that needs to get converted
     * @return : roman string
     * @throws MainAppException
     */
    public String convertIntToRoman(int number) throws MainAppException {
        StringBuilder ans = new StringBuilder();

        try {
            // finding the largest value in values array that fits the number and decrementing it from number till it becomes
            // less than or equal to 0
            for (int i = 0; number > 0; i++)
                while (number >= values[i]) {
                    ans.append(romans[i]);
                    number -= values[i];
                }
        } catch (Exception e) {
            logger.error("something wrong with the int to roman conversion");
            throw new MainAppException(e.getMessage());
        }

        return ans.toString();
    }

    /**
     * input validation
     * @param query : number recieved from the request.
     * @return request input in integer format.
     * @throws MainAppException
     */
    public static int validateInput(String query) throws MainAppException {
        try {
            int number = Integer.parseInt(query);
            if (number <= 0 || number >= 4000) {
                logger.error("input is not in the range : " + query);
                throw  new MainAppException("input should be in range 1-3999");
            }
            return number;
        } catch (MainAppException ex) {
            throw  new MainAppException("input should be in range 1-3999");
        } catch (Exception e) {
            logger.error("input doesn't contain numbers only: " + query);
            throw  new MainAppException("input should strictly have numbers : " + query);
        }
    }
}
