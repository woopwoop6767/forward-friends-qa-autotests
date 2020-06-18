package qa.front.friends.logic;

import org.apache.commons.lang3.RandomStringUtils;


public interface GenerateText {

    default String generateMobilePhone() {
        return "9".concat(RandomStringUtils.randomNumeric(9));
    }
}
