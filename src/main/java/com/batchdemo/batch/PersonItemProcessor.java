package com.batchdemo.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import com.batchdemo.model.Person;

public class PersonItemProcessor
    implements ItemProcessor<Person, String> {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(PersonItemProcessor.class);

  @Override
  public String process(Person person) throws Exception {
    String greeting =  person.getFirstName() + person.getLastName();
    
    int s = 4; //shift by 4
    String encryptedGreet;
    encryptedGreet = encrypt(greeting, s);
    
    LOGGER.info("converting '{}' into '{}'", person, encryptedGreet);
    return encryptedGreet;
  }
  
  
  /**
   * Encrypts text using shift
   * @param text
   * @param s
   * @return
   */
  public String encrypt(String text, int s) 
  { 
      StringBuffer result= new StringBuffer(); 

      for (int i=0; i<text.length(); i++) 
      { 
          if (Character.isUpperCase(text.charAt(i))) 
          { 
              char ch = (char)(((int)text.charAt(i) + 
                                s - 65) % 26 + 65); 
              result.append(ch); 
          } 
          else
          { 
              char ch = (char)(((int)text.charAt(i) + 
                                s - 97) % 26 + 97); 
              result.append(ch); 
          } 
      } 
      return result.toString(); 
  } 

}
