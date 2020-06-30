package qa.front.friends.logic;

import org.apache.commons.lang3.RandomStringUtils;


public interface GenerateText {


    default String generateMobilePhone() {
        return new StringBuilder().append(9).append(RandomStringUtils.randomNumeric(9)).toString();
    }

}
